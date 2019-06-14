package json_placeholder_spring_service;

import json_placeholder_model.response.PostResponse;
import json_placeholder_model.response.PostsResponse;

public class Main {

    public static void main(String[] args) {

        Client client = new Client();

        // get one post
        PostResponse post = client.getPost("2");

        // get all posts
        PostsResponse posts = client.getAllPosts();

        System.out.println(posts.toString());

    }

}
