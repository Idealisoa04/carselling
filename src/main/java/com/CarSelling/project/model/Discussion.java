package com.CarSelling.project.model;

import com.CarSelling.project.entity.UtilisateurEntity;

public class Discussion {

    UtilisateurEntity recipient;
    Integer iddiscussion;
    Integer myId;
    
    public Discussion(UtilisateurEntity recipient, Integer iddiscussion, Integer myId) {
        this.recipient = recipient;
        this.iddiscussion = iddiscussion;
        this.myId = myId;
    }

    public UtilisateurEntity getRecipient() {
        return recipient;
    }

    public void setRecipient(UtilisateurEntity recipient) {
        this.recipient = recipient;
    }

    public Integer getIddiscussion() {
        return iddiscussion;
    }

    public void setIddiscussion(Integer iddiscussion) {
        this.iddiscussion = iddiscussion;
    }

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    
}
