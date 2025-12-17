package com.javaraquel.cadastro_usuario.controller;

import com.javaraquel.cadastro_usuario.DTO.RegisterDTO;
import com.javaraquel.cadastro_usuario.infrastructure.entity.User;
import com.javaraquel.cadastro_usuario.infrastructure.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserRepository repository;

    public AuthenticationController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data) {


        if (repository.findByUsername(data.login()) != null) {
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }


        User newUser = new User(data.login(), data.password(), data.role());


        repository.save(newUser);

        return ResponseEntity.ok().body("Usuário registrado com sucesso!");
    }
}
