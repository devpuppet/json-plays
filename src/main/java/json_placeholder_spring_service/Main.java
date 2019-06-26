package json_placeholder_spring_service;

import json_placeholder_model.request.PostRequest;
import json_placeholder_model.response.PhotoResponse;
import json_placeholder_model.response.PostResponse;
import json_placeholder_model.response.PostsResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotations.EmptyPostRequest;
import spring.config.SpringMainConfig;
import utils.BrowserHelper;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringMainConfig.class);

        JSONPlaceholderService service = context
                .getBean(JSONPlaceholderService.class);

        Map<String, Object> defaultEmptyPostRequestBean =
                context.getBeansWithAnnotation(EmptyPostRequest.class);

        //PostRequest defaultPostRequestBean = context.getBean(PostRequest.class);

        // get one post
        PostResponse post = service.getPost("2");

        // get all posts
        PostsResponse posts = service.getAllPosts();

        // create new post
        PostRequest newPost = new PostRequest.Builder()
                .withBody("new post")
                .withTitle("Brand new")
                .withUserId(12)
                .build();
        PostResponse newPostResponse = service.createPost(newPost);

        // update post
        PostRequest updatedPost = new PostRequest.Builder()
                .withBody("updated!")
                .withTitle("updates v2")
                .withUserId(1)
                .build();
        PostResponse updateResponse = service.updatePost("1", updatedPost);

        // delete post
        boolean isPostDeleted = service.deletePost("2");

        // get photo
        PhotoResponse photo = service.getPhoto("20");
        BrowserHelper.openURL(photo.getUrl());

        System.out.println(posts.toString());

    }

}
