package com.cvcompany.vo.myapplication.Module;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinh on 8/23/2017.
 */

public class Picture  {

    @SerializedName("Title")
    private String title;
    @SerializedName("Image")
    private String image;
    @SerializedName("Response")
    private String response;

    public Picture(String title, String image ) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

}
