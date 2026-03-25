package com.revature.routing.listener;


import com.revature.routing.model.CallEvent;
import com.revature.routing.service.RoutingService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tools.jackson.dataformat.xml.XmlMapper;


@Component
public class CallEventListener {

    private final RoutingService routingService;
    private final XmlMapper xmlMapper = new XmlMapper();

    public CallEventListener(RoutingService routingService) {
        this.routingService = routingService;
    }

    @JmsListener(destination = "call.routing.queue")
    public void processCall(String callEventMessage) {
        try {
            CallEvent callevent = xmlMapper.readValue(callEventMessage, CallEvent.class);
            routingService.routeCall(callevent);
        } catch (Exception e) {
            System.out.println("Failed to process call: " + e.getMessage());
        }
    }
}
