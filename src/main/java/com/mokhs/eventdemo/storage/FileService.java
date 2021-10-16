package com.mokhs.eventdemo.storage;

import com.mokhs.eventdemo.event.FileEvent;
import com.mokhs.eventdemo.event.FileEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {

    private final FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {
        try {
            log.info("파일 복사 완료");
            log.info("DB 파일 메타 정보 저장 완료");
            FileEvent completeEvent = FileEvent.toCompleteEvent(data);

            fileEventPublisher.notifyComplete(completeEvent);

        } catch (Exception e) {
            log.error("file upload fail", e);
            FileEvent errorEvent = FileEvent.toCompleteEvent(data);
            fileEventPublisher.notifyError(errorEvent);
        }
    }

}
