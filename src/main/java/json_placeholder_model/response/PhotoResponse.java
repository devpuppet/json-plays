
package json_placeholder_model.response;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class PhotoResponse {

    @Expose
    private Integer albumId;
    @Expose
    private Integer id;
    @Expose
    private String thumbnailUrl;
    @Expose
    private String title;
    @Expose
    private String url;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
