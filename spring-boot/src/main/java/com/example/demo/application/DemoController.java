package com.example.demo.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    /**
     * <pre>
     *      curl http://localhost:8080/demo
     * </pre>
     */
    @GetMapping("/demo")
    public Map<String, Object> findSomething() throws InterruptedException, ExecutionException {
        final Future<List<String>> futureDogs = demoService.findDogs("id");
        final Future<List<String>> futureCats = demoService.findCats("id");

        final List<String> dogs = futureDogs.get();
        final List<String> cats = futureCats.get();

        Map<String, Object> family = new HashMap<>();
        family.put("dogs", dogs);
        family.put("cats", cats);

        return family;
    }

}
