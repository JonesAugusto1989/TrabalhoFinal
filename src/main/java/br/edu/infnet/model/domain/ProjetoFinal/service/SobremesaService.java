package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.Exceptions.SobremesaException;
import br.edu.infnet.model.domain.ProjetoFinal.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Sobremesa")
public class SobremesaService implements ISobremesaService {
    Logger logger = LoggerFactory.getLogger(SobremesaService.class);
    @Autowired
    SolicitanteService solicitanteService;

    public Map<Integer, Sobremesa> sgbdSobremesaInit() {

        Map<Integer, Sobremesa> sgbdSobremesa = new HashMap<>();

        for (Solicitante solicitante : solicitanteService.findAll()) {

            if (solicitante.getPedidos() != null) {
                for (Pedido pedido : solicitante.getPedidos()) {
                    for (Produto produto : pedido.getProdutos()) {
                        if (produto.getTipo() != null) {
                            if (produto.getTipo().equals("sobremesa")) {
                                Sobremesa sobremesa = (Sobremesa) produto;
                                sgbdSobremesa.put(sobremesa.getCodigo(), sobremesa);
                            }
                        }
                    }
                }
            }
        }
        return sgbdSobremesa;
    }

    public List<Sobremesa> findAll() {
        return sgbdSobremesaInit().values().stream().toList();

    }

    public void delete(int id) {
        Produto produto = null;
        Pedido pedidoTemp = null;

        try {

            for (Solicitante solicitante : solicitanteService.findAll()) {
                if (solicitante.getPedidos() != null) {
                    for (Pedido pedido : solicitante.getPedidos()) {
                        for (Produto produtoTemp : pedido.getProdutos()) {
                            if (produtoTemp.getCodigo() == id) {
                                pedidoTemp = pedido;
                                produto = produtoTemp;
                                break;
                            }
                        }
                    }
                }
            }
            if (produto == null) {
                throw new SobremesaException(id);
            }
        } catch (SobremesaException e) {
            logger.info(e.toSring());
        }

        if (produto != null) {
            for (Solicitante solicitante : solicitanteService.findAll()) {
                if (solicitante.getPedidos() != null) {
                    if (pedidoTemp.getProdutos().contains(produto)) {
                        pedidoTemp.getProdutos().remove(produto);
                    }
                }
            }
        }
    }
}
