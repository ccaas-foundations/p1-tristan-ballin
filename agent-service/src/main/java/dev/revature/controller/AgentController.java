package dev.revature.controller;

import dev.revature.entity.Agent;
import dev.revature.entity.AgentCategory;
import dev.revature.entity.AgentStatus;
import dev.revature.repository.AgentRepository;
import dev.revature.service.AgentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentController {

    private AgentService agentService;

    public AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @GetMapping(value = "/agents")
    public List<Agent> getAgents(@RequestParam(name = "category",required = false) AgentStatus status,
                                 @RequestParam(name = "category",required = false) AgentCategory category){
        if (status!=AgentStatus.AVAILABLE&&category!=null){
            return agentService.getAvailableAgentsByCategory(category);
        }
        return agentService.getAgents();
    }

    @GetMapping(value = "/agents/{id}")
    public Agent getAgentsById(@PathVariable long id){
        return agentService.getAgentById(id);
    }





}
