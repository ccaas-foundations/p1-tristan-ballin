package dev.revature.service;

import dev.revature.model.CallEvent;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RoutingService {

    @Transactional
    public void routeCall(CallEvent callEvent){

    }
}
