package json_placeholder_spring_service;

import json_placeholder_model.request.PostRequest;
import json_placeholder_model.response.PostResponse;
import json_placeholder_model.response.PostsResponse;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class Client {

    private static final String POST_RESOURCE_URL = "https://jsonplaceholder.typicode.com/posts/";

    private RestTemplate restTemplate;
    private HttpEntity<String> entity;

    public Client() {
        restTemplate = new RestTemplate();

//        List<HttpMessageConverter<?>> converters = new ArrayList<>();
//        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
//        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
//        converters.add(converter);
//        restTemplate.setMessageConverters(converters);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<>("parameters", httpHeaders);
    }

    private <T> T sendGetRequest(String url, Class<T> responseType, Map<String, String> params) {
        T response = restTemplate.getForObject(url, responseType, params);
        return response;
    }

    private <T> T sendGetRequest(String url, Class<T> responseType) {
        T response = restTemplate.getForObject(url, responseType);
        return response;
    }

    private <T> T sendPostRequest(String url, Object body, Class<T> responseType) {
        return restTemplate.postForObject(url, body, responseType);
    }

    public PostResponse getPost(String postId) {
        Map<String, String> params = new HashMap<>();
        params.put("id", postId);

        return sendGetRequest(POST_RESOURCE_URL + "{id}", PostResponse.class, params);
    }

    public PostsResponse getAllPosts() {
        PostResponse[] response = sendGetRequest(POST_RESOURCE_URL, PostResponse[].class);
        return new PostsResponse(response);
    }

    public PostResponse createPost(PostRequest post) {
        return sendPostRequest(POST_RESOURCE_URL, post, PostResponse.class);
    }

}
