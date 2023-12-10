package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.Pedido;

import java.util.List;

public interface IPedidoService {

    List<Pedido> findAll();

    void delete(int id);

}
