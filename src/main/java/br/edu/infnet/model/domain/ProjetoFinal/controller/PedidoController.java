package br.edu.infnet.model.domain.ProjetoFinal.controller;

import br.edu.infnet.model.domain.ProjetoFinal.model.Comida;
import br.edu.infnet.model.domain.ProjetoFinal.model.Pedido;
import br.edu.infnet.model.domain.ProjetoFinal.model.Produto;

import br.edu.infnet.model.domain.ProjetoFinal.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    Logger logger = LoggerFactory.getLogger("PedidoController.class");

    @GetMapping
    public List<Pedido> findAll() {
        logger.info("Metodo FindAll pedidos iniciado:");
       return pedidoService.findAll();
    }

@DeleteMapping("/{id}")
public void delete(@PathVariable int id) {
    logger.info("Metodo Deletar pedido iniciado:");
    pedidoService.delete(id);
}

}

