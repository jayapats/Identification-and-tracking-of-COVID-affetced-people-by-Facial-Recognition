package com.example.service.objects.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class SaveImageDB {

    @JsonProperty("id")
    private String id;

    @JsonProperty("imageData")
    private String imageData;

    @JsonProperty("name")
    private String name;

    @JsonProperty("loc")
    private String loc;

    @Override
    public String toString() {
        return "SaveImageDB{" +
                "id='" + id + '\'' +
                ", imageData='" + imageData + '\'' +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    @JsonProperty("dateTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateTime;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
