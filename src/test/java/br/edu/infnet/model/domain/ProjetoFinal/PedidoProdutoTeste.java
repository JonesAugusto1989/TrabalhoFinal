package br.edu.infnet.model.domain.ProjetoFinal;

import br.edu.infnet.model.domain.ProjetoFinal.model.*;
import br.edu.infnet.model.domain.ProjetoFinal.service.SolicitanteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class PedidoProdutoTeste {

    @Autowired
    SolicitanteService solicitanteService;



    @Test
    public void cadastrarPedido() {
        String[] ingredientes = {"massa", "carne"};
        Produto produto1 = new Comida("Nhoque", 20f, 9, "comida", 11f, false, ingredientes);

        List<Produto> listaDeProduto1 = new ArrayList<>();
        listaDeProduto1.add(produto1);
        List<Pedido> listaDePedidos1 = new ArrayList<>();
        Pedido pedido1 = new Pedido("Pedido 1", true, listaDeProduto1);
        listaDePedidos1.add(pedido1);
        Solicitante solicitante = new Solicitante("Usuario 1", "3333333333", "usuario1@email.com",listaDePedidos1);
        solicitanteService.create(solicitante);

        Produto produto2 = new Bebida("Guaravita", 20f, 5, "bebida", true, 0.5f, "Guaraviton");
        List<Produto> listaDeProduto2 = new ArrayList<>();
        listaDeProduto2.add(produto2);
        List<Pedido> listaDePedidos2 = new ArrayList<>();
        Pedido pedido2 = new Pedido("Pedido 2", true, listaDeProduto2);
        listaDePedidos2.add(pedido2);
        Solicitante solicitante2 = new Solicitante("Usuario 2", "44444444", "usuario2@email.com",listaDePedidos2);

        solicitanteService.create(solicitante2);
        Produto produto3 = new Sobremesa("Leite moça", 50f, 8, "sobremesa", 2, true, "Doce de leite moça");
        List<Produto> listaDeProduto3 = new ArrayList<>();
        listaDeProduto3.add(produto3);
        Pedido pedido3 = new Pedido("Pedido 2", true, listaDeProduto3);
        List<Pedido> listaDePedidos3 = new ArrayList<>();
        listaDePedidos3.add(pedido3);
        Solicitante solicitante3 = new Solicitante("Usuario 3", "55555555555555", "usuario3@email.com",listaDePedidos3);
        solicitanteService.create(solicitante3);




    }

}
