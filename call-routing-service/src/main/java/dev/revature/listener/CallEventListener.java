package dev.revature.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.revature.model.CallEvent;
import dev.revature.service.RoutingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
public class CallEventListener {

    private final RoutingService routingService;

    public CallEventListener(RoutingService routingService) {
        this.routingService = routingService;
    }

    @JmsListener(destination = "${queue.call-routing}")
    public void processCall(String callEventMessage) throws JsonProcessingException {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            CallEvent callevent = xmlMapper.readValue(callEventMessage, CallEvent.class);
            routingService.routeCall(callevent);
    }
}
