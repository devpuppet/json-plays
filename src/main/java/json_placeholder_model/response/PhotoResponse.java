
package json_placeholder_model.response;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class PhotoResponse {

    @Expose
    private Long albumId;
    @Expose
    private Long id;
    @Expose
    private String thumbnailUrl;
    @Expose
    private String title;
    @Expose
    private String url;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
