package com.etiya.corepackage.abstractions.messaging.transport;

import com.etiya.corepackage.abstractions.events.Event;

public interface EventBusConsumer<TEvent extends Event> {
    void consume(TEvent event);
}
