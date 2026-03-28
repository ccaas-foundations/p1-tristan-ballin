package dev.revature.repository;

import dev.revature.entity.InboundCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InboundCallRepository extends JpaRepository<InboundCall,Long> {
    List<InboundCall> findInboundCallByAgentId(long agentId);
}
