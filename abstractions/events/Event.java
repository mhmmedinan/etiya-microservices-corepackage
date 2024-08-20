package com.etiya.corepackage.abstractions.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Event {
    private UUID eventId;
    private String topicName;

    public Event(){
        this.eventId=UUID.randomUUID();
    }
}
