package dev.revature;

import dev.revature.entity.Agent;
import dev.revature.entity.AgentCategory;
import dev.revature.entity.AgentStatus;
import dev.revature.repository.AgentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final AgentRepository agentRepository;

    public DataLoader(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        Agent a1 = new Agent("Alice","alice@gmail.com", AgentStatus.AVAILABLE, Set.of(AgentCategory.TECHNICAL, AgentCategory.GENERAL));
        Agent a2 = new Agent("Bob","bob@gmail.com", AgentStatus.AVAILABLE, Set.of(AgentCategory.BILLING, AgentCategory.GENERAL));
        Agent a3 = new Agent("Carol","carol@gmail.com", AgentStatus.AVAILABLE, Set.of(AgentCategory.SALES, AgentCategory.BILLING));
        Agent a4 = new Agent("David","david@gmail.com", AgentStatus.ON_CALL, Set.of(AgentCategory.TECHNICAL));
        Agent a5 = new Agent("Eve","eve@gmail.com", AgentStatus.OFFLINE, Set.of(AgentCategory.GENERAL));

        agentRepository.save(a1);
        agentRepository.save(a2);
        agentRepository.save(a3);
        agentRepository.save(a4);
        agentRepository.save(a5);

    }
}
