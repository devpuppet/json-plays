package json_placeholder_model.response;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class PostsResponse {

    List<PostResponse> posts;

    public PostsResponse(PostResponse[] posts) {
        this.posts = Arrays.asList(posts);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",\n");
        for (PostResponse post : posts) {
            stringJoiner.add(post.toString());
        }
        return stringJoiner.toString();
    }

}
