package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.Exceptions.SolicitanteException;
import br.edu.infnet.model.domain.ProjetoFinal.model.Produto;
import br.edu.infnet.model.domain.ProjetoFinal.model.Sobremesa;
import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import br.edu.infnet.model.domain.ProjetoFinal.model.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SolicitanteService implements ISolicitanteService {


    Map<Integer, Solicitante> bd = sgbdInit();
    private int num = 4;
    Logger logger = LoggerFactory.getLogger("SolicitanteService.class");

    public Map<Integer, Solicitante> sgbdInit() {


        Solicitante solicitante1 = new Solicitante("Marcos", "11111111111", "marcos@teste1.com");
        Solicitante solicitante2 = new Solicitante("Ana", "22222222222222", "ana@teste2.com");

        Sobremesa sobremesa = new Sobremesa("Sorvete De Chocolate",30.5F,10,"sobremesa",2,true,"Sorvete muito gostoso");

        List<Produto> prod = new ArrayList<>();
        prod.add(sobremesa);
        Pedido pedido1 = new Pedido("Pedido 1", prod);
        List<Pedido> listaPedido = new ArrayList<>();
        listaPedido.add(pedido1);
        Solicitante solicitante3 = new Solicitante("Grazi", "33333333333333333333333", "Grazi@teste3.com", listaPedido);
        Map<Integer, Solicitante> solicitantes = new HashMap<>();

        solicitantes.put(1, solicitante1);
        solicitantes.put(2, solicitante2);
        solicitantes.put(3, solicitante3);
        return solicitantes;
    }

    public List<Solicitante> findAll() {

        return this.bd.values().stream().toList();
    }

    public void delete(int id) {
        bd.remove(id);
    }

    public void create(Solicitante solicitante) {

        bd.put(num, solicitante);
        num++;

    }

    public void update(int id, Solicitante solicitante) {

        bd.replace(id, solicitante);

    }

    public Solicitante solicitanteFindById(int id) {
        Solicitante s = null;
        try {

            for (Solicitante solicitante : bd.values()) {
                if (solicitante.getId() == id) {
                    s = solicitante;
                    return s;
                }

            }
            if (s == null) {
                throw new SolicitanteException(id);
            }
        } catch (SolicitanteException e) {
            logger.info(e.toString());
        }
        return null;
    }


}
