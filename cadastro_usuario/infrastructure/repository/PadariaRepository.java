package com.javaraquel.cadastro_usuario.infrastructure.repository;

import com.javaraquel.cadastro_usuario.infrastructure.entity.Padaria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PadariaRepository extends MongoRepository<Padaria,String> {
}
