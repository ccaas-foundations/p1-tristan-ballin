package dev.revature.controllers;

import dev.revature.entity.AgentStatus;
import dev.revature.entity.InboundCall;
import dev.revature.repository.InboundCallRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CallController {

    private final InboundCallRepository inboundCallRepository;

    public CallController(InboundCallRepository inboundCallRepository){
        this.inboundCallRepository = inboundCallRepository;
    }

    //get /calls InboundCall records - all call history
    //get /calls?agent-id={id} | InboundCall records for this agent |
    @GetMapping(value = "/calls")
    public List<InboundCall> getCalls(@RequestParam(name = "agentId",required = false) Long id){
        if (id!=null){
            List<InboundCall> calls = inboundCallRepository.findInboundCallByAgentId(id);
                if (calls.isEmpty()){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No calls from agent: "+id);
                }
                return calls;
        }
        return inboundCallRepository.findAll();
    }
}
