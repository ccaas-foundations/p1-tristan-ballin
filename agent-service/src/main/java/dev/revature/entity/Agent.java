package dev.revature.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private AgentStatus status;
    @ElementCollection()
    @CollectionTable(name = "agent_categories", joinColumns = @JoinColumn(name = "agent_id"))
    private Set<AgentCategory> categories;

    public Agent() {
    }

    public Agent(String name, String email, AgentStatus status, Set<AgentCategory> categories) {
        this.name = name;
        this.email = email;
        this.status = status;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AgentStatus getStatus() {
        return status;
    }

    public void setStatus(AgentStatus status) {
        this.status = status;
    }

    public Set<AgentCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<AgentCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return Objects.equals(id, agent.id) && Objects.equals(name, agent.name) && Objects.equals(email, agent.email) && status == agent.status && Objects.equals(categories, agent.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, status, categories);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", categories=" + categories +
                '}';
    }
}
