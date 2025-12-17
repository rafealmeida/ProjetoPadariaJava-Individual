package com.javaraquel.cadastro_usuario.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CompraDTO {
    private String usuarioid;
    private List<String>produtosIds;

}