package com.juzung.wespeak.models;

/**
 * Created by VTDung on 5/1/20.
 * <p>
 * Item contains data such as:
 * id: Id of item (optional)
 * title: Title of button
 * bgColor: background color (optional)
 * mediaPath: Path to sound file
 */
public class PlaylistItem {

    private String id;

    private String title;

    // Color must have format of hex color. Ex: #636161
    private String bgColor;

    private String mediaPath;

    public PlaylistItem() {
    }

    public PlaylistItem(String id, String title, String bgColor, String mediaPath) {
        this.id = id;
        this.title = title;
        this.bgColor = bgColor;
        this.mediaPath = mediaPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }
}
