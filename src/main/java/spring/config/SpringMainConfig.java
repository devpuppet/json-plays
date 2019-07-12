package spring.config;

import json_placeholder_spring_service.JSONPlaceholderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import spring.exercise_classes.aspect.Communication;
import spring.exercise_classes.aspect.MagazineControl;
import spring.exercise_classes.designators.Designators;

@Configuration
@EnableAspectJAutoProxy
@Import({SpringExplicitConfig.class, SpringImplicitConfig.class})
public class SpringMainConfig {

    @Bean(name = "jsonPlaceholderService")
    public JSONPlaceholderService service() {
        return new JSONPlaceholderService();
    }

    @Bean
    public MagazineControl magazineControlAspect() {
        return new MagazineControl();
    }

    @Bean
    public Communication communication() {
        return new Communication();
    }

    @Bean
    public Designators designators() {
        return new Designators();
    }

}
