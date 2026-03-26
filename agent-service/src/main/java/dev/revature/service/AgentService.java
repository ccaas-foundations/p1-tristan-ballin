package dev.revature.service;

import dev.revature.entity.Agent;
import dev.revature.entity.AgentCategory;
import dev.revature.entity.AgentStatus;
import dev.revature.repository.AgentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }

    public List<Agent> getAgents(){
        return agentRepository.findAll();
    }

    public Agent getAgentById(Long id){
        return agentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found"));
    }

    public List<Agent> getAvailableAgentsByCategory(AgentCategory category){
            return agentRepository.findAgentsByAvailableStatusAndCategory(category);
    }
    public  Agent createAgent(Agent agent){
        return agentRepository.save(agent);
    }

    public  Agent updateAgent(long id, AgentStatus status){
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found"));
        agent.setStatus(status);
        return agentRepository.save(agent);
    }
}
