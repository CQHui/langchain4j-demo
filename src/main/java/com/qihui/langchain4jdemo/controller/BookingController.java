package com.qihui.langchain4jdemo.controller;

import com.qihui.langchain4jdemo.agent.BookingAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BookingController {
    private final BookingAgent bookingAgent;

    public BookingController(BookingAgent bookingAgent) {
        this.bookingAgent = bookingAgent;
    }

    @GetMapping("/booking/chat")
    public Flux<String> bookingChat(@RequestParam String sessionId, @RequestParam String userMessage) {
        return bookingAgent.answer(sessionId, userMessage);
    }
}
