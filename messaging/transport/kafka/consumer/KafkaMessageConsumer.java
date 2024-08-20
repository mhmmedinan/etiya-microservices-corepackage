package com.etiya.corepackage.messaging.transport.kafka.consumer;

import com.etiya.corepackage.abstractions.events.Event;
import com.etiya.corepackage.abstractions.messaging.transport.EventBusConsumer;
import com.etiya.corepackage.abstractions.messaging.transport.EventBusSubscriber;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KafkaMessageConsumer implements EventBusSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumer.class);
    private final DefaultKafkaConsumerFactory<String,Event> consumerFactory;


    @Override
    public <TEvent extends Event> void subscribe(TEvent event, EventBusConsumer<TEvent> consumer) {
        Map<String,Object> consumerProps = new HashMap<>(consumerFactory.getConfigurationProperties());
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG,event.getTopicName() + ".group");
        KafkaConsumer<String,Event> kafkaConsumer = new KafkaConsumer<>(consumerProps);
        kafkaConsumer.subscribe(Collections.singletonList(event.getTopicName()));
        new Thread(()->{
            try{
                while (true){
                    kafkaConsumer.poll(Duration.ofMillis(100)).forEach((record->{
                        LOGGER.info("Consumed Event : {}",record.value());
                        consumer.consume((TEvent) record.value());
                    }));
                }
            }
            catch (WakeupException e){
                LOGGER.info("Consumer wakeup exception : {}",e.getMessage());
            }
            finally {
                kafkaConsumer.close();
            }
        }).start();

    }
}
