package br.edu.infnet.model.domain.ProjetoFinal.controller;
import br.edu.infnet.model.domain.ProjetoFinal.model.Sobremesa;
import br.edu.infnet.model.domain.ProjetoFinal.service.SobremesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sobremesa")
public class SobremesaController {

    @Autowired
    SobremesaService sobremesaService;

    @GetMapping
    public List<Sobremesa> findAll(){

        return sobremesaService.findAll();
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable int codigo){
        sobremesaService.delete(codigo);

    }
}
