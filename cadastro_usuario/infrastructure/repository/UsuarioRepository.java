package com.javaraquel.cadastro_usuario.infrastructure.repository;

import com.javaraquel.cadastro_usuario.infrastructure.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByCpf(String cpf);

    void deleteByCpf(String cpf);
}
