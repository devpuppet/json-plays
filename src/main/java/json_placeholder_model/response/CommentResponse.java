
package json_placeholder_model.response;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class CommentResponse {

    @Expose
    private String body;
    @Expose(deserialize = false)
    private String email;
    @Expose
    private Long id;
    @Expose
    private String name;
    private Long postId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

}
