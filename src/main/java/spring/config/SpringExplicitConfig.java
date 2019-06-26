package spring.config;

import json_placeholder_model.request.PostRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotations.EmptyPostRequest;

@Configuration
public class SpringExplicitConfig {

    @Bean
    public PostRequest defaultPostRequest(@Value("Default") String body,
                                          @Value("Default") String title,
                                          @Value("0") Integer userId) {
        return new PostRequest.Builder()
                .withBody(body)
                .withTitle(title)
                .withUserId(userId)
                .build();
    }


    @Bean
    @EmptyPostRequest
    public PostRequest defaultEmptyPostRequest(@Value("") String body,
                                               @Value("") String title,
                                               @Value("0") Integer userId) {
        return new PostRequest.Builder()
                .withBody(body)
                .withTitle(title)
                .withUserId(userId)
                .build();
    }

}
