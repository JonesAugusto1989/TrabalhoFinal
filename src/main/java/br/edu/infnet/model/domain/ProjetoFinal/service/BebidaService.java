package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Bebida")
public class BebidaService implements IBebidaService{

    @Autowired
    SolicitanteService solicitanteService;
    public Map<Integer, Bebida> sgbdBebidaInit() {

        Map<Integer, Bebida> sgbdBebida = new HashMap<>();

        for (Solicitante solicitante : solicitanteService.findAll()) {

            if(solicitante.getPedidos()!= null){
                for(Pedido pedido: solicitante.getPedidos()){
                    for(Produto produto: pedido.getProdutos()){
                        if(produto.getTipo() != null){
                            if(produto.getTipo().equals("bebida")){
                                Bebida bebida = (Bebida) produto;
                                sgbdBebida.put(bebida.getCodigo(), bebida);
                            }
                        }
                    }
                }
            }
        }
        return sgbdBebida;
    }

    public List<Bebida> findAll(){
        return sgbdBebidaInit().values().stream().toList();

    }

    public void delete(int id) {
        Produto produto = null;
        Pedido pedidoTemp = null;
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
