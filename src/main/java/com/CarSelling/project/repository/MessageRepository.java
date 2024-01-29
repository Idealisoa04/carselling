package com.CarSelling.project.repository;
import java.util.List;

import com.CarSelling.project.model.Message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findByRecipient(String recipient);

    List<Message> findByIddiscussion(Integer iddiscussion);

    // @Query("{ 'iddiscussion' : ?0, 'sender' : ?1 }")
    // List<Message> findByIddiscussionSender(Integer iddiscussion, String sender);

    // @Query("{ 'iddiscussion' : ?0, 'recipient' : ?1 }")
    // List<Message> findByIddiscussionRecipient(Integer iddiscussion, String recipient);

    // @Query("{ $or: [ { 'sender' : ?0 }, { 'recipient' : ?0 } ], 'iddiscussion' : ?1 }")
    // List<Message> findAllMessages(String iduser, Integer iddiscussion);
}

