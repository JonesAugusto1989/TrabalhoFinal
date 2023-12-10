package br.edu.infnet.model.domain.ProjetoFinal.controller;

import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import br.edu.infnet.model.domain.ProjetoFinal.service.SolicitanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Solicitante")
public class SolicitanteController {

    private int num = 3;

    @Autowired
    SolicitanteService solicitanteService;

    Logger logger = LoggerFactory.getLogger("PedidoController.class");

    @GetMapping
    public List<Solicitante> findAll() {
        logger.info("Metodo FindAll Solicitantes iniciado:");
        return solicitanteService.findAll();
    }

    @GetMapping("/{id}")
    public Solicitante solicitanteFindById(@PathVariable int id) {
        logger.info("Metodo solicitanteFindById Solicitantes iniciado:");
        return solicitanteService.solicitanteFindById(id);
    }

    @PutMapping
    public void update() {
        logger.info("Metodo Alterar Solicitante iniciado:");
        Solicitante s =  new Solicitante("Diego","33333333333","Diego@teste4.com");
        solicitanteService.update(3,s);
    }


    @DeleteMapping
    public void delete() {
        logger.info("Metodo Deletar Solicitante iniciado:");
        solicitanteService.delete(1);

    }

    @PostMapping
    public void create(@RequestBody Solicitante solicitante) {
        logger.info("Metodo Cadastrar Solicitante iniciado:");
        this.solicitanteService.create(solicitante);
        num++;
    }



}
