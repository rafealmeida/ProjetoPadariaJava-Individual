package com.javaraquel.cadastro_usuario.business;

import com.javaraquel.cadastro_usuario.DTO.CompraDTO;
import com.javaraquel.cadastro_usuario.infrastructure.entity.Compra;
import com.javaraquel.cadastro_usuario.infrastructure.entity.Padaria;
import com.javaraquel.cadastro_usuario.infrastructure.entity.Usuario;
import com.javaraquel.cadastro_usuario.infrastructure.repository.CompraRepository;
import com.javaraquel.cadastro_usuario.infrastructure.repository.PadariaRepository;
import com.javaraquel.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CompraService {

    private final UsuarioRepository usuarioRepository;
    private final CompraRepository compraRepository;
    private final UsuarioService usuarioService;
    private final PadariaRepository padariaRepository;

    private Double calcularValorTotal(List<Padaria> produtos) {
        return produtos.stream()
                .mapToDouble(Padaria::getValor)
                .sum();
    }

    public Compra criarCompraComDTO(CompraDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioid())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<Padaria> produtos = padariaRepository.findAllById(dto.getProdutosIds());

        Compra compra = Compra.builder()
                .id(usuario.getId())
                .dataCompra(LocalDateTime.now())
                .valorTotal(calcularValorTotal(produtos))
                .build();

        return compraRepository.save(compra);
    }


    public Compra criarCompraComDTO(String id, Compra compra) {
        compra.setId(id);
        return compraRepository.save(compra);
    }
}