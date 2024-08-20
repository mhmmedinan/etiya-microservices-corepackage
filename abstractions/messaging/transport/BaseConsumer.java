package com.etiya.corepackage.abstractions.messaging.transport;

import com.etiya.corepackage.abstractions.events.Event;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseConsumer<TEvent extends Event> implements EventBusConsumer<TEvent> {

    private final EventBusSubscriber eventBusSubscriber;
    private final Class<? extends TEvent> classType;


    public void startConsuming() throws Exception{
        TEvent event = classType.getConstructor().newInstance();
        this.eventBusSubscriber.subscribe(event,this);
    }

}
