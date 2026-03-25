package dev.revature.agent.repository;

import dev.revature.agent.entity.Agent;
import dev.revature.agent.entity.AgentStatus;
import dev.revature.agent.entity.CallCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query("SELECT a FROM Agent a JOIN a.categories c WHERE a.status = :status AND c = :category")
    List<Agent> findAgentsByStatusAndCategory(@Param("status")AgentStatus status, @Param("category")CallCategory category);

}
