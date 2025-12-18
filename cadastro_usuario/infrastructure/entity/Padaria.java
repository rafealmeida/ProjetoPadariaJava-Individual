package com.javaraquel.cadastro_usuario.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "padarias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Padaria {

    @Id
    private String id;
    private String produtos;
    private Double valor;
}