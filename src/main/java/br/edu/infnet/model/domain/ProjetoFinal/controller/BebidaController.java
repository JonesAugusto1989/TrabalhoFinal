package br.edu.infnet.model.domain.ProjetoFinal.controller;

import br.edu.infnet.model.domain.ProjetoFinal.model.Bebida;
import br.edu.infnet.model.domain.ProjetoFinal.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Bebida")
public class BebidaController {
    @Autowired
    BebidaService bebidaService;

    @GetMapping
    public List<Bebida> findAll(){

        return bebidaService.findAll();
    }

    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable int codigo){
        bebidaService.delete(codigo);

    }
}
