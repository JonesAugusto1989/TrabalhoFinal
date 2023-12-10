package br.edu.infnet.model.domain.ProjetoFinal.service;


import br.edu.infnet.model.domain.ProjetoFinal.model.Produto;

import java.util.List;

public interface IProdutoService {

    List<Produto> findAll();

    void delete(int id);



    Produto getProdutoByCodigo(int codigo);

}
