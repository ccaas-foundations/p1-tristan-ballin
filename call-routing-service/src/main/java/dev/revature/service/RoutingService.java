package dev.revature.service;

import dev.revature.dto.AgentSummary;
import dev.revature.entity.CallCategory;
import dev.revature.entity.CallStatus;
import dev.revature.entity.InboundCall;
import dev.revature.model.CallEvent;
import dev.revature.repository.InboundCallRepository;
import jakarta.transaction.Transactional;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class RoutingService {

    private final RestClient restClient;
    private final InboundCallRepository inboundCallRepository;
    public RoutingService(RestClient.Builder restClientBuilder, InboundCallRepository inboundCallRepository){
        this.restClient = restClientBuilder.build();
        this.inboundCallRepository = inboundCallRepository;
    }

    //parse callCategory and default to GENERAL
    public static CallCategory parseCategory(String value) {
        try {
            return CallCategory.valueOf(value);
        } catch (IllegalArgumentException | NullPointerException e) {
            return CallCategory.GENERAL;
        }
    }

    @Transactional
    public void routeCall(CallEvent callEvent){

        CallCategory parsedCategory = parseCategory(callEvent.getCallCategory());

        //Query for available agent
        List<AgentSummary> agents = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("agents")
                        .queryParam("category",parsedCategory)
                        .build()
                ).exchange((request, response) ->{
                    if (response.getStatusCode().is2xxSuccessful()){
                        return response.bodyTo(new ParameterizedTypeReference<List<AgentSummary>>() {});
                    }else{
                        return Collections.<AgentSummary>emptyList();
                    }
        });
        //if none found, log and return
        if(agents == null || agents.isEmpty()){
            System.out.println("No agent found for category: "+ parsedCategory+" and Id: "+callEvent.getCallId());
            return;
        }
        //persist InboundCall with assigned agent, category, callId, and timestamp
        AgentSummary firstAvailableAgent = agents.getFirst();
        InboundCall inboundCall = new InboundCall(callEvent.getCallId()
                ,callEvent.getCallerNumber()
                ,parsedCategory
                ,firstAvailableAgent.getId()
                ,callEvent.getReceivedAt()
                ,CallStatus.ASSIGNED);
        inboundCallRepository.save(inboundCall);

        //call agent-service via restTemplate to update agent status to ON_CALL
        restClient.put()
                .uri(uriBuilder -> uriBuilder
                        .path("agents/{id}/status")
                        .build(firstAvailableAgent.getId())
                )
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("status","ON_CALL"))
                .retrieve()
                .toBodilessEntity();


    }
}
