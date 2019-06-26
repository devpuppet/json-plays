package spring.config;

import json_placeholder_spring_service.JSONPlaceholderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SpringExplicitConfig.class, SpringImplicitConfig.class})
public class SpringMainConfig {

    @Bean(name = "jsonPlaceholderService")
    public JSONPlaceholderService service() {
        return new JSONPlaceholderService();
    }

}
