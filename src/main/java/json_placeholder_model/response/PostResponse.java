
package json_placeholder_model.response;

import com.google.gson.annotations.Expose;
import gson_json.json.JsonHelper;

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

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new JsonHelper().parseObjectToJson(this);
    }

}
