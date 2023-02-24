package com.example.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebService {

    private final WebClient webClient;

    public WebService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getExample() {
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .bodyToMono(String.class);
    }
}
