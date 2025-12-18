package com.javaraquel.cadastro_usuario.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "compras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compra {

    @Id
    private String id;

    @DBRef
    private Usuario usuario;

    @DBRef 
    private List<Padaria> produtos;

    @Field("data_compra")
    private LocalDateTime dataCompra;

    @Field("valor_total")
    private Double valorTotal;
}