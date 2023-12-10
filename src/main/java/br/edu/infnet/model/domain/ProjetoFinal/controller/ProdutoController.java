package br.edu.infnet.model.domain.ProjetoFinal.controller;

import br.edu.infnet.model.domain.ProjetoFinal.model.Produto;
import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import br.edu.infnet.model.domain.ProjetoFinal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        produtoService.delete(id);
    }

    @GetMapping("/{codigo}")
    public Produto getProdutoByCodigo(@PathVariable int codigo){
     return produtoService.getProdutoByCodigo(codigo);
    }



}
