package com.CarSelling.project.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.CarSelling.project.entity.DiscussionEntity;
import com.CarSelling.project.entity.UtilisateurEntity;
import com.CarSelling.project.model.Discussion;
import com.CarSelling.project.repository.DiscussionRepository;
import com.CarSelling.project.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscussionService {
    
    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public DiscussionEntity getOneDiscussion(Integer iduser1, Integer iduser2) throws Exception{
        try{
            return discussionRepository.findOneDiscussion(iduser1, iduser2);
        } catch(Exception e){
            throw e;
        }
    }

    public List<DiscussionEntity> getAllDiscussion(Integer iduser) throws Exception{
        try{
            return discussionRepository.findAllDiscussion(iduser);
        } catch(Exception e){
            throw e;
        }
    }

    public List<Discussion> getAllDiscussionDescri(Integer iduser) throws Exception{
        try {
            List<Discussion> rep = new ArrayList<Discussion>();
            List<DiscussionEntity> all = discussionRepository.findAllDiscussion(iduser);
            for(int i=0 ; i<all.size() ; i++){
                System.out.println("heerree");
                Integer recipient = all.get(i).getIduser1();
                if(recipient == iduser){
                    recipient = all.get(i).getIduser2();
                }
                System.out.println(recipient+"user"+iduser);
                UtilisateurEntity user = this.findUserDescriById(recipient);
                rep.add(new Discussion(user,all.get(i).getIddiscussion(),iduser));
            }
            return rep;
        } catch (Exception e) {
            throw e;
        }
    }

    public UtilisateurEntity findUserDescriById(Integer id){
        Object[] data = this.utilisateurRepository.findUserDescriById(id);
        UtilisateurEntity user = new UtilisateurEntity();
            user.setNom(data[0].toString());
            user.setPrenom(data[1].toString());
            user.setDateNaissance((Date) data[2]);
            user.setSexe((Integer) data[3]);
            user.setEmail(data[4].toString());
            System.out.println(user.getNom());
            return user;
    }

    public void insertDiscussion(Integer iduser1, Integer iduser2) throws Exception{
        try {
            discussionRepository.insertDiscussion(iduser1, iduser2);
        } catch (Exception e) {
            throw e;
        }
    }
}
