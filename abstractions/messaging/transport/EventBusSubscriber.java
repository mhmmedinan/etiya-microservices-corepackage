package com.etiya.corepackage.abstractions.messaging.transport;

import com.etiya.corepackage.abstractions.events.Event;

public interface EventBusSubscriber {
    <TEvent extends Event> void subscribe(TEvent event,EventBusConsumer<TEvent> consumer);
}
