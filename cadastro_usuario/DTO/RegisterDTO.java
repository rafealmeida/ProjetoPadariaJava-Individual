package com.javaraquel.cadastro_usuario.DTO;

import com.javaraquel.cadastro_usuario.role.UserRole;
import lombok.Data;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}