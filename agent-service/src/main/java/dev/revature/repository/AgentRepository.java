package dev.revature.repository;

import dev.revature.entity.Agent;
import dev.revature.entity.AgentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query("SELECT a FROM Agent a JOIN a.categories c WHERE a.status = 'AVAILABLE' AND c = :category")
    List<Agent> findAgentsByAvailableStatusAndCategory(@Param("category") AgentCategory category);

}
