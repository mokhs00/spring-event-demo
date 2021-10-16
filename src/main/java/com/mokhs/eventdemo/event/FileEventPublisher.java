package com.mokhs.eventdemo.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher; // application event publisher

    public void notifyComplete(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }

    public void notifyError(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }
}
