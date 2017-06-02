package com.example;

import kamon.annotation.Count;
import kamon.annotation.EnableKamon;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by anarwal on 6/2/17.
 */

@RestController
@EnableKamon
public class GreetingController {
        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @RequestMapping("/greeting")
        @Count(name = "greetingCounter")
        public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
            return new Greeting(counter.incrementAndGet(),
                    String.format(template, name));
        }
}
