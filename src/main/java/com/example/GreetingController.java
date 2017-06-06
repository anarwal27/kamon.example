package com.example;

import kamon.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableKamon
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    @Trace("GreetingTrace")
    @Histogram(name = "GreetingHistogram")
    @Count(name = "greetingCounter")
    @MinMaxCount(name = "GreetingMinMaxCount")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
