package com.example.service.objects.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveImage {

    @JsonProperty("imageData")
    private String imageData;

    @JsonProperty("name")
    private String name;

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SaveImage{" +
                "imageData='" + imageData + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
