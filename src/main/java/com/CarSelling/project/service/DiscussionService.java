package com.CarSelling.project.service;

import java.util.List;

import com.CarSelling.project.entity.DiscussionEntity;
import com.CarSelling.project.repository.DiscussionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscussionService {
    
    @Autowired
    private DiscussionRepository discussionRepository;

    public DiscussionEntity getOneDiscussion(Integer iduser1, Integer iduser2) throws Exception{
        try{
            return discussionRepository.findOneDiscussion(iduser1, iduser2);
        } catch(Exception e){
            throw e;
        }
    }

    public List<DiscussionEntity> getAllDiscussion(Integer iduser) throws Exception{
        try{
            // List<DiscussionEntity> all = discussionRepository.findAllDiscussion(iduser);
            // for(int i=0 ; i<all.size() ; i++){
            //     Integer recipient = all.get(i).getIduser1();
            //     if(recipient == iduser){
            //         recipient = all.get(i).getIduser2();
            //     }
            //     all.get(i).getInfoRecipient(recipient);
            // }
            // return all;
            return discussionRepository.findAllDiscussion(iduser);
        } catch(Exception e){
            throw e;
        }
    }

    public void insertDiscussion(Integer iduser1, Integer iduser2) throws Exception{
        try {
            discussionRepository.insertDiscussion(iduser1, iduser2);
        } catch (Exception e) {
            throw e;
        }
    }
}
