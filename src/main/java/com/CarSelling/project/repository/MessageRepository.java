package com.CarSelling.project.repository;
import java.util.List;

import com.CarSelling.project.model.Message;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findByRecipient(String recipient);

}

