package com.javaraquel.cadastro_usuario.business;

import com.javaraquel.cadastro_usuario.infrastructure.entity.User;
import com.javaraquel.cadastro_usuario.infrastructure.repository.UserRepository;
import com.javaraquel.cadastro_usuario.role.UserRole;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository repository;

    public AuthenticationService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean userExists(String login) {
        return repository.findByUsername(login) != null;
    }

    public void registerUser(String login, String password, String roleStr) {
        if (userExists(login)) {
            throw new RuntimeException("Usuário já existe!");
        }

        String rawPassword = password;

        UserRole roleEnum;
        try {
            roleEnum = UserRole.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Role inválida: " + roleStr);
        }

        User newUser = new User(login, rawPassword, roleEnum);

        repository.save(newUser);
    }

    public User findByLogin(String login) {
        return repository.findByUsername(login);
    }
}