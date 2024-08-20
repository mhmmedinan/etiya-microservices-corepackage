package com.etiya.corepackage.configuration;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    Pipeline pipeline(ObjectProvider<Command.Handler> commaHandlers,
                      ObjectProvider<Notification.Handler> notificationHandlers,
                      ObjectProvider<Command.Middleware> middlewares){
        return new Pipelinr()
                .with(commaHandlers::stream)
                .with(notificationHandlers::stream)
                .with(middlewares::orderedStream);
    }

}
