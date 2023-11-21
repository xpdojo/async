package com.example.demo.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

@Slf4j
@Service
public class DemoService {

    @Async
    public Future<List<String>> findDogs(String id) throws InterruptedException {
        log.debug("findDogs");
        Thread.sleep(1_000);
        if (isBlank(id)) {
            return new AsyncResult<>(Collections.emptyList());
        }
        return new AsyncResult<>(List.of("dog1", "dog2"));
    }

    @Async
    public Future<List<String>> findCats(String id) throws InterruptedException {
        log.debug("findCats");
        Thread.sleep(1_000);
        if (isBlank(id)) {
            return new AsyncResult<>(Collections.emptyList());
        }
        return new AsyncResult<>(List.of("cat1", "cat2"));
    }

    private boolean isBlank(String str) {
        return str == null || "".equals(str.strip());
    }
}
