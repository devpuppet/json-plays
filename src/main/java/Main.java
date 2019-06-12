import json_placeholder_apache_service.Client;
import json_placeholder_model.request.PostRequest;
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
        PostResponse post = client.createNewPost(postRequest);

        System.out.println(toDo);

    }

}
