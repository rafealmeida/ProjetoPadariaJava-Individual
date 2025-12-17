package com.javaraquel.cadastro_usuario.infrastructure.repository;

import com.javaraquel.cadastro_usuario.infrastructure.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);

}