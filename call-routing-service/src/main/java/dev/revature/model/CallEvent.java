package dev.revature.model;



import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import dev.revature.entity.CallCategory;

import java.time.LocalDateTime;

@JacksonXmlRootElement
public class CallEvent {
    @JacksonXmlProperty(localName = "callId")
    private String callId;
    @JacksonXmlProperty(localName = "callCategory")
    private CallCategory callCategory;
    @JacksonXmlProperty(localName = "callerNumber")
    private String callerNumber;
    @JacksonXmlProperty(localName = "callerName")
    private String callerName;
    @JacksonXmlProperty(localName = "timestamp")
    private LocalDateTime receivedAt;

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public CallCategory getCallCategory() {
        return callCategory;
    }

    public void setCallCategory(CallCategory callCategory) {
        this.callCategory = callCategory;
    }

    public String getCallerNumber() {
        return callerNumber;
    }

    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public CallEvent() {
    }

}
