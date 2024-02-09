package com.CarSelling.project.model;

import java.util.Map;

import lombok.Data;

@Data
public class NotificationMessage {
    private String recipientToken;
    private String title;
    private String body;
    private String image;
    private Map<String,String> data;
    
    public String getRecipientToken() {
        return recipientToken;
    }
    public void setRecipientToken(String recipientToken) {
        this.recipientToken = recipientToken;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Map<String, String> getData() {
        return data;
    }
    public void setData(Map<String, String> data) {
        this.data = data;
    }

    
}
