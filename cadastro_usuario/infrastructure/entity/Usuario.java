package com.javaraquel.cadastro_usuario.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "usuario")
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate datanascimento;

}
