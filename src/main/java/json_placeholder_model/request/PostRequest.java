
package json_placeholder_model.request;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class PostRequest {

    @Expose
    private String title;
    @Expose
    private String body;
    @Expose
    private Integer userId;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUserId() {
        return userId;
    }

    public static class Builder {

        private String title;
        private String body;
        private Integer userId;

        public PostRequest.Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public PostRequest.Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PostRequest.Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public PostRequest build() {
            PostRequest postRequest = new PostRequest();
            postRequest.title = title;
            postRequest.body = body;
            postRequest.userId = userId;
            return postRequest;
        }

    }

}
