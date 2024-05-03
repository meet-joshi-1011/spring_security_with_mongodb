package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
}
