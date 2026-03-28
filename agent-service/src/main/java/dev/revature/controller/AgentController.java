package dev.revature.controller;

import dev.revature.entity.Agent;
import dev.revature.entity.AgentCategory;
import dev.revature.entity.AgentStatus;
import dev.revature.repository.AgentRepository;
import dev.revature.service.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @GetMapping(value = "/agents")
    public List<Agent> getAgents(@RequestParam(name = "status",required = false) AgentStatus status,
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

    @PostMapping(value = "/agents")
    public Agent createAgent(Agent agent){
        return agentService.createAgent(agent);
    }

    @PutMapping(value = "/agents/{id}/status")
    public Agent updateAgent(@PathVariable long id,
                             @RequestBody Map<String, String> body){
        AgentStatus status = AgentStatus.valueOf(body.get("status"));
        return agentService.updateAgent(id, status);
    }





}
