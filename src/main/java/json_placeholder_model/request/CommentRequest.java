
package json_placeholder_model.request;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class CommentRequest {

    @Expose
    private String body;
    @Expose
    private String email;
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private Integer postId;

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPostId() {
        return postId;
    }

    public static class Builder {

        private Integer postId;
        private Integer id;
        private String name;
        private String email;
        private String body;

        public CommentRequest.Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public CommentRequest.Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CommentRequest.Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public CommentRequest.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public CommentRequest.Builder withPostId(Integer postId) {
            this.postId = postId;
            return this;
        }

        public CommentRequest build() {
            CommentRequest commentRequest = new CommentRequest();
            commentRequest.body = body;
            commentRequest.email = email;
            commentRequest.id = id;
            commentRequest.name = name;
            commentRequest.postId = postId;
            return commentRequest;
        }

    }

}
