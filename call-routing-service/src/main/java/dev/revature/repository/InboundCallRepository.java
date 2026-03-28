package dev.revature.repository;

import dev.revature.entity.InboundCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboundCallRepository extends JpaRepository<InboundCall,Long> {
}
