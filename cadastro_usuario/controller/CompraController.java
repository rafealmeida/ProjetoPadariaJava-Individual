package com.javaraquel.cadastro_usuario.controller;

import com.javaraquel.cadastro_usuario.business.CompraService;
import com.javaraquel.cadastro_usuario.infrastructure.entity.Compra;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/compas")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PutMapping("/{id}")
    public Compra atualizar(@RequestBody Compra compra, @PathVariable String id){
        return compraService.criarCompraComDTO(id, compra);
    }

}
