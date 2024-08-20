package com.etiya.corepackage.messaging.transport.kafka.producer;

import com.etiya.corepackage.abstractions.events.Event;
import com.etiya.corepackage.abstractions.messaging.transport.EventBusProducer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducer implements EventBusProducer {

    private final KafkaTemplate<String,Event> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);


    @Override
    public <TEvent extends Event> void produce(TEvent event) {

        LOGGER.info(String.format("%s created event => %s",event.getClass().getSimpleName(),event.toString()));
        Message<TEvent> message = MessageBuilder.withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,event.getTopicName())
                .build();
        kafkaTemplate.send(message);

    }
}
