package dev.revature.dto;

import dev.revature.entity.AgentStatus;
import dev.revature.entity.CallCategory;

import java.util.Objects;
import java.util.Set;

public class AgentSummary {
    private Long id;
    private String name;
    private String email;
    private AgentStatus status;
    private Set<CallCategory> categories;

    public AgentSummary() {
    }

    public AgentSummary(Long id, String name, String email, AgentStatus status, Set<CallCategory> categories) {
        this.id = id;
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

    public Set<CallCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<CallCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AgentSummary that = (AgentSummary) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && status == that.status && Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, status, categories);
    }

    @Override
    public String toString() {
        return "AgentSummary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", categories=" + categories +
                '}';
    }
}
