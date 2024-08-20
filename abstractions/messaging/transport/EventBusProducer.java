package com.etiya.corepackage.abstractions.messaging.transport;

import com.etiya.corepackage.abstractions.events.Event;

public interface EventBusProducer {
  <TEvent extends Event>  void produce(TEvent event);
}
