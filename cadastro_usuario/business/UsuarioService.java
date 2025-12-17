package com.javaraquel.cadastro_usuario.business;

import com.javaraquel.cadastro_usuario.infrastructure.entity.Usuario;
import com.javaraquel.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService {
    private final UsuarioRepository reposity;

    public UsuarioService(UsuarioRepository repository) {
        this.reposity = repository;
    }
    public Usuario salvarUsuario(Usuario usuario){
        return reposity.save(usuario);
    }
    public Usuario buscarPorCpf(String cpf){
        return reposity.findByCpf(cpf)
                .orElseThrow(()-> new RuntimeException("Cpf não encotrado"));
    }
    public void deletarPorCpf(String cpf){
        reposity.deleteByCpf(cpf);
    }
    public Usuario atualizarPorCpf(String cpf ,Usuario usuario){
        Usuario usuarioEntity=reposity.findById(cpf).orElseThrow(()->new RuntimeException("Usuario nao Encontrado"));

        if (usuario.getNome() != null) {
            usuarioEntity.setNome(usuario.getNome());
        }
        if (usuario.getTelefone() != null) {
            usuarioEntity.setTelefone(usuario.getTelefone());
        }

        if (usuario.getDatanascimento() != null) {
            usuarioEntity.setDatanascimento(usuario.getDatanascimento());
        }

        return reposity.save(usuarioEntity);
    }

}
