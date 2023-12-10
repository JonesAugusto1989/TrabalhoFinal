package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.Exceptions.PedidoException;
import br.edu.infnet.model.domain.ProjetoFinal.model.Pedido;
import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PedidoService implements IPedidoService {

    Logger logger = LoggerFactory.getLogger("PedidoController.class");
    @Autowired
    SolicitanteService solicitanteService;


    public Set<Pedido> sgbdPedidoInit() {

        Set<Pedido> sgbdPedido = new HashSet<>();
        for (Solicitante solicitante : solicitanteService.findAll()) {
            if (solicitante.getPedidos() != null) {
                sgbdPedido.addAll(solicitante.getPedidos());
            }
        }
        return sgbdPedido;
    }

    public List<Pedido> findAll() {
        return sgbdPedidoInit().stream().toList();
    }


    public void delete(int id) {
        Pedido pedido = null;
        try {

        for (Solicitante solicitante : solicitanteService.findAll()) {
            if (solicitante.getPedidos() != null) {
                for (Pedido pedidoTemporario : solicitante.getPedidos()) {
                    if (pedidoTemporario.getId() == id) {
                        pedido = pedidoTemporario;
                        break;
                    }
                }
            }
        }
        if(pedido == null){
            throw new PedidoException(id);
        }
        }catch(PedidoException e){
            logger.info(e.toString());
        }

        if (pedido != null) {

            for (Solicitante solicitante : solicitanteService.findAll()) {
                if (solicitante.getPedidos() != null) {
                    solicitante.getPedidos().remove(pedido);
                    break;
                }
            }
        }
    }


}





