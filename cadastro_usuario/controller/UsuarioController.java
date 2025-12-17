package com.javaraquel.cadastro_usuario.controller;

import com.javaraquel.cadastro_usuario.business.UsuarioService;
import com.javaraquel.cadastro_usuario.infrastructure.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;




    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario BuscarPorId(@PathVariable String cpf) {
        return usuarioService.buscarPorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String cpf) {
        usuarioService.deletarPorCpf(cpf);
    }
    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable String id){
        return usuarioService.atualizarPorCpf(id,usuario);
    }
}