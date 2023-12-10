package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.Comida;
import br.edu.infnet.model.domain.ProjetoFinal.model.Pedido;
import br.edu.infnet.model.domain.ProjetoFinal.model.Produto;
import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComidaService implements IComidaService {

    @Autowired
    SolicitanteService solicitanteService;
    public Map<Integer, Comida> sgbdComidaInit() {

        Map<Integer, Comida> sgbdComida = new HashMap<>();

        for (Solicitante solicitante : solicitanteService.findAll()) {

            if(solicitante.getPedidos()!= null){
                for(Pedido pedido: solicitante.getPedidos()){
                    for(Produto produto: pedido.getProdutos()){
                        if(produto.getTipo() != null){
                            if(produto.getTipo().equals("comida")){
                                Comida comida = (Comida) produto;
                                sgbdComida.put(comida.getCodigo(), comida);
                            }
                        }
                    }
                }
            }
        }
        return sgbdComida;
    }

    public List<Comida> findAll(){
        return sgbdComidaInit().values().stream().toList();

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
