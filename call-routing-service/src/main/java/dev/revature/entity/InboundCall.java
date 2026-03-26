package dev.revature.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class InboundCall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String callId;
    private String callerNumber;
    @Enumerated(EnumType.STRING)
    private CallCategory callCategory;
    private long agentId;
    private LocalDateTime receivedAt;
    @Enumerated(EnumType.STRING)
    private CallStatus status;

    public InboundCall() {
    }

    public InboundCall(String callId, String callerNumber, CallCategory callCategory, long agentId, LocalDateTime receivedAt, CallStatus status) {
        this.callId = callId;
        this.callerNumber = callerNumber;
        this.callCategory = callCategory;
        this.agentId = agentId;
        this.receivedAt = receivedAt;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getCallerNumber() {
        return callerNumber;
    }

    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }

    public CallCategory getCallCategory() {
        return callCategory;
    }

    public void setCallCategory(CallCategory callCategory) {
        this.callCategory = callCategory;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public CallStatus getStatus() {
        return status;
    }

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InboundCall that = (InboundCall) o;
        return id == that.id && Objects.equals(callId, that.callId) && Objects.equals(callerNumber, that.callerNumber) && callCategory == that.callCategory && Objects.equals(agentId, that.agentId) && Objects.equals(receivedAt, that.receivedAt) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, callId, callerNumber, callCategory, agentId, receivedAt, status);
    }

    @Override
    public String toString() {
        return "InboundCall{" +
                "id=" + id +
                ", callId='" + callId + '\'' +
                ", callerNumber='" + callerNumber + '\'' +
                ", callCategory=" + callCategory +
                ", agentId=" + agentId +
                ", receivedAt=" + receivedAt +
                ", status=" + status +
                '}';
    }
}
