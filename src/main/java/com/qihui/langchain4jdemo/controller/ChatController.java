package com.qihui.langchain4jdemo.controller;

import com.qihui.langchain4jdemo.agent.CustomerSupportAgent;
import com.qihui.langchain4jdemo.agent.ReviewerAgent;
import dev.langchain4j.service.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final CustomerSupportAgent customerSupportAgent;
    private final ReviewerAgent reviewerAgent;

    public ChatController(CustomerSupportAgent customerSupportAgent, ReviewerAgent reviewerAgent) {
        this.customerSupportAgent = customerSupportAgent;
        this.reviewerAgent = reviewerAgent;
    }

    @GetMapping("/customerSupportAgent")
    public String customerSupportAgent(@RequestParam String sessionId, @RequestParam String userMessage) {
        Result<String> result = customerSupportAgent.answer(sessionId, userMessage);
        return result.content();
    }

    @GetMapping("/review")
    public Boolean review(@RequestParam String sessionId, @RequestParam String userMessage) {
        Result<Boolean> result = reviewerAgent.answer(sessionId, userMessage);
        return result.content();
    }
}
