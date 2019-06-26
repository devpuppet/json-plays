package spring;

import gson_json.json.JsonHelper;
import json_placeholder_model.request.PostRequest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.SpringMainConfig;

public class Application {

    private JsonHelper jsonHelper;
    private AnnotationConfigApplicationContext context;

    public void run() {
        context = new AnnotationConfigApplicationContext(SpringMainConfig.class);
        jsonHelper = context.getBean(JsonHelper.class);

        PostRequest emptyPostRequest = (PostRequest) context.getBean("defaultEmptyPostRequest");

        System.out.println(jsonHelper.parseObjectToJson(emptyPostRequest));
    }

}
