package com.revature.agent.controller;

import com.revature.agent.entity.Agent;
import com.revature.agent.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentController {

    private AgentService agentService;

    public AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @GetMapping(value = "/agents")
    public List<Agent> getAgents(){
        return agentService.findAll();
    }

    @GetMapping(value = "/agents/{id}")
    public List<Agent> getAgentsById(@PathVariable long id){
        return agentService.findAgentById();
    }

    @GetMapping(value = "/agents")
    public List<Agent> getAgents(){
        return agentService.findAll();
    }

}
