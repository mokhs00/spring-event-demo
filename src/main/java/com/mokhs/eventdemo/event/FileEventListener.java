package com.mokhs.eventdemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileEventListener {

    @EventListener // spring event 를 받을 수 있음
    public void onFileEventHandler(FileEvent fileEvent) {
        log.info("fileEvent received type: {}, data : {}", fileEvent.getType(), fileEvent.getData());

        if (fileEvent.getType().equals(EventType.COMPLETE.name())) {
            log.info("사용자에게 complete message 를 전달.");
            return;
        }

        if (fileEvent.getType().equals(EventType.ERROR.name())) {
            log.info("사용자에게 error message 를 전달.");
            return;
        }

    }
}
