package com.CarSelling.project.model;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "messages")
public class Message {

    @Id
    private ObjectId _id;

    @Field(name = "sender")
    private String sender;

    @Field(name = "recipient")
    private String recipient;

    @Field(name = "content")
    private String content;

    @Field(name = "date")
    private LocalDateTime date;

    @Field(name = "iddiscussion")
    private Integer iddiscussion;
    
    public Message(String sender, String recipient, String content, LocalDateTime date, Integer iddiscussion) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.date = date;
        this.iddiscussion = iddiscussion;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) throws Exception {
        try {
            this.date = date;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getIddiscussion() {
        return iddiscussion;
    }

    public void setIddiscussion(Integer iddiscussion) {
        this.iddiscussion = iddiscussion;
    }

    
}
