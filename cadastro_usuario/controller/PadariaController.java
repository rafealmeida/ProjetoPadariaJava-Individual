package com.javaraquel.cadastro_usuario.controller;

import com.javaraquel.cadastro_usuario.business.PadariaService;
import com.javaraquel.cadastro_usuario.infrastructure.entity.Padaria;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/padaria")
public class PadariaController {
    private final PadariaService padariaService;


    public PadariaController(PadariaService padariaService) {
        this.padariaService = padariaService;
    }

    @PostMapping
    public Padaria cadastrar(@RequestBody Padaria padaria) {
        return padariaService.CadastrProduto(padaria);
    }

    @GetMapping("/{id}")
    public Padaria BuscarPorId(@PathVariable String id) {
        return padariaService.BuscaPadariaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        padariaService.deletarProdutoPorId(id);
    }
    @PutMapping("/{id}")
    public Padaria atualizar(@RequestBody Padaria padaria, @PathVariable String id){
        return padariaService.AtualizaProdutoPorId(id,padaria);
    }
}
