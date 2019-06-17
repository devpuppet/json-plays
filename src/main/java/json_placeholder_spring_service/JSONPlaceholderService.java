package json_placeholder_spring_service;

import json_placeholder_model.request.PostRequest;
import json_placeholder_model.response.PhotoResponse;
import json_placeholder_model.response.PostResponse;
import json_placeholder_model.response.PostsResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class JSONPlaceholderService {

    private static final String POST_RESOURCE_URL =
            "https://jsonplaceholder.typicode.com/posts/";
    private static final String PHOTO_RESOURCE_URL =
            "https://jsonplaceholder.typicode.com/photos/";

    private Client client = new Client();

    public PostResponse getPost(String postId) {
        ResponseEntity<PostResponse> response = client.sendRequest(POST_RESOURCE_URL + postId,
                HttpMethod.GET, null, PostResponse.class);
        return response.getBody();
    }

    public PostsResponse getAllPosts() {
        ResponseEntity<PostResponse[]> response = client.sendRequest(POST_RESOURCE_URL,
                HttpMethod.GET, null, PostResponse[].class);
        return new PostsResponse(response.getBody());
    }

    public PostResponse createPost(PostRequest post) {
        ResponseEntity<PostResponse> response = client.sendRequest(POST_RESOURCE_URL,
                HttpMethod.POST, post, PostResponse.class);
        return response.getBody();
    }

    public PostResponse updatePost(String postId, PostRequest updatedPost) {
        ResponseEntity<PostResponse> response = client.sendRequest(POST_RESOURCE_URL + postId,
                HttpMethod.PUT, updatedPost, PostResponse.class);
        return response.getBody();
    }

    public boolean deletePost(String postId) {
        ResponseEntity<PostResponse> response = client.sendRequest(POST_RESOURCE_URL + postId,
                HttpMethod.DELETE, null, PostResponse.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public PhotoResponse getPhoto(String photoId) {
        ResponseEntity<PhotoResponse> response = client.sendRequest(PHOTO_RESOURCE_URL + photoId,
                HttpMethod.GET, null, PhotoResponse.class);
        return response.getBody();
    }

    // this method is used for mockito practice
    public PhotoResponse getPhotoWithColor(String color) {
        return new PhotoResponse();
    }
}
