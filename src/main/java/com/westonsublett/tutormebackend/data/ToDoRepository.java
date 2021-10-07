package com.westonsublett.tutormebackend.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {


}
