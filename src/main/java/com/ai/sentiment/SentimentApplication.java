package com.ai.sentiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class SentimentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentimentApplication.class, args);
    }

    @GetMapping("/api/sentiment")
    public Map<String, String> analyzeSentiment(@RequestParam(value = "text", defaultValue = "hello") String text) {


        String textLower = text.toLowerCase();
        boolean isNegative = textLower.matches(".*(bad|terrible|hate|sad|awful|angry).*");

        String result = isNegative ? "negative" : "positive";

        return Map.of(
                "text", text,
                "sentiment", result
        );
    }
}