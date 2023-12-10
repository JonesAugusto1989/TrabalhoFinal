package br.edu.infnet.model.domain.ProjetoFinal.controller;

import br.edu.infnet.model.domain.ProjetoFinal.model.Comida;
import br.edu.infnet.model.domain.ProjetoFinal.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comida")
public class ComidaController {

    @Autowired
    ComidaService comidaService;

    @GetMapping
    public List<Comida> findAll(){

        return comidaService.findAll();
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable int codigo){
        comidaService.delete(codigo);

    }
}
