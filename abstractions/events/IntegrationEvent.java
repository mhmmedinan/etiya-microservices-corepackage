package com.etiya.corepackage.abstractions.events;

import java.util.UUID;


public class IntegrationEvent extends Event {
    private UUID correlationId;

    public IntegrationEvent(){
        this.correlationId=UUID.randomUUID();
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
    }
}
