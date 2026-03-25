package com.revature.agent.service;

import com.revature.agent.entity.Agent;
import com.revature.agent.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }

    public List<Agent> getAgent(){
        return agentRepository.findAll();
    }
    public Agent getAgentById(Long id){
        Optional<Agent> agent = agentRepository.findById(id);
        if (agent.isEmpty() || agent.get().getId() == null){
            return null;
        }
        return agent.get();
    }
}
