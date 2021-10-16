package com.mokhs.eventdemo.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileEvent {
    private String eventId;
    private String type;
    private Map<String, Object> data;

    public static FileEvent toCompleteEvent(Map data) {
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.COMPLETE.name())
                .data(data)
                .build();
    }

    public static FileEvent toErrorEvent(Map data) {
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.COMPLETE.name())
                .data(data)
                .build();
    }
}
