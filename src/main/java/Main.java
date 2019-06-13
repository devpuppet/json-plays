import json_placeholder_apache_service.Client;
import json_placeholder_model.request.CommentRequest;
import json_placeholder_model.request.PostRequest;
import json_placeholder_model.response.CommentResponse;
import json_placeholder_model.response.PhotoResponse;
import json_placeholder_model.response.PostResponse;
import json_placeholder_model.response.ToDo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Client client = new Client();

        // get single ToDo
        ToDo toDo = client.getToDosResponse("5");

        // get all ToDos
        List<ToDo> toDos = client.getToDosResponse();

        // create new post
        PostRequest postRequest = new PostRequest.Builder()
                .withTitle("this is my first post request!")
                .withBody("test post")
                .withUserId(107)
                .build();
        PostResponse postResponse = client.createNewPost(postRequest);

        // update comment
        CommentRequest commentRequest = new CommentRequest.Builder()
                .withBody("Comment update test")
                .withEmail("abc@gmail.com")
                .withId(107)
                .withName("Batman")
                .withPostId(167)
                .build();
        CommentResponse putResponse = client.updateComment(commentRequest);

        // delete comment
        String deleteResponse = client.deleteComment("4");

        // get post for user
        List<PostResponse> postForUser = client.getPostsForUserId("6");

        // get all comments for post
        List<CommentResponse> comments = client.getCommentsForPost("3");

        // get photo
        PhotoResponse photoResponse = client.getPhoto("4");
        BrowserHelper.openURL(photoResponse.getUrl());

        System.out.println(toDo);

    }

}
