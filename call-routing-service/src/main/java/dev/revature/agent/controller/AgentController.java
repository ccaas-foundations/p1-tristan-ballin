package dev.revature.agent.controller;

import dev.revature.agent.entity.Agent;
import dev.revature.agent.service.AgentService;
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
        return agentService.getAgent();
    }

    @GetMapping(value = "/agents/{id}")
    public Agent getAgentsById(@PathVariable long id){
        return agentService.getAgentById(id);
    }

//    @GetMapping(value = "/agents")
//    public List<Agent> getAgents(){
//        return agentService.findAll();
//    }

}
