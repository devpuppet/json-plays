
package json_placeholder_model.response;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class ToDo {

    @Expose
    private Boolean completed;
    @Expose
    private Long id;
    @Expose(deserialize = false)
    private String title;
    @Expose
    private Long userId;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
