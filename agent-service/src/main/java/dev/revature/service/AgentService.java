package dev.revature.service;

import dev.revature.entity.Agent;
import dev.revature.entity.AgentCategory;
import dev.revature.entity.AgentStatus;
import dev.revature.repository.AgentRepository;
import org.springframework.stereotype.Service;

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
        Optional<Agent> agent = agentRepository.findById(id);
        if (agent.isEmpty() || agent.get().getId() == null){
            return null;
        }
        return agent.get();
    }

    public List<Agent> getAvailableAgentsByCategory(AgentCategory category){
            return agentRepository.findAgentsByAvailableStatusAndCategory(category);
    }
}
