package com.etiya.corepackage.abstractions.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class IntegrationEvent extends Event {
    private UUID correlationId;

    private IntegrationEvent(){
        this.correlationId=UUID.randomUUID();
    }
}
