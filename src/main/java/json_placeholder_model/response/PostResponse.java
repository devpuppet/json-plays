
package json_placeholder_model.response;

import com.google.gson.annotations.Expose;
import gson_json.json.JsonHelper;

import java.util.Objects;

@SuppressWarnings("unused")
public class PostResponse {

    @Expose
    private Integer id;
    @Expose
    private String title;
    @Expose
    private String body;
    @Expose
    private Integer userId;

    public String getBody() {
        return body;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostResponse that = (PostResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(body, that.body) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, userId);
    }

    @Override
    public String toString() {
        return new JsonHelper().parseObjectToJson(this);
    }

    public static class Builder {
        private Integer id;
        private String title;
        private String body;
        private Integer userId;

        public PostResponse.Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public PostResponse.Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PostResponse.Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public PostResponse.Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public PostResponse build() {
            PostResponse postResponse = new PostResponse();
            postResponse.id = id;
            postResponse.title = title;
            postResponse.body = body;
            postResponse.userId = userId;
            return postResponse;
        }

    }

}
