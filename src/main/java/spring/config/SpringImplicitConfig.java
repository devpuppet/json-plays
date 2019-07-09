package spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "json_placeholder_spring_service",
        "gson_json",
        "spring"})
public class SpringImplicitConfig {
}
