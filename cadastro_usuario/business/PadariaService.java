package com.javaraquel.cadastro_usuario.business;

import com.javaraquel.cadastro_usuario.infrastructure.entity.Padaria;
import com.javaraquel.cadastro_usuario.infrastructure.repository.PadariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import com.javaraquel.cadastro_usuario.infrastructure.entity.Padaria;
import com.javaraquel.cadastro_usuario.infrastructure.repository.PadariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadariaService {

    public Padaria CadastrProduto(Padaria padaria) {
        // lógica de salvar
        return padaria;
    }

    public Padaria BuscaPadariaPorId(String id) {
        // lógica de buscar
        return null;
    }

    public void deletarProdutoPorId(String id) {
        // lógica de deletar
    }

    public Padaria AtualizaProdutoPorId(String id, Padaria padaria) {
        // lógica de atualizar
        return padaria;
    }
}

