package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.Pedido;
import br.edu.infnet.model.domain.ProjetoFinal.model.Produto;
import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProdutoService implements IProdutoService {
    @Autowired
    SolicitanteService solicitanteService;
    @Autowired
    PedidoService pedidoService;



    public Set<Produto> sgbdProdutoInit() {
        Set<Produto> sgbdProduto = new HashSet<>();
        for (Solicitante solicitante : solicitanteService.findAll()) {
            if (solicitante.getPedidos() != null) {
                for (Pedido pedido : solicitante.getPedidos()) {
                    for (Produto produto : pedido.getProdutos()) {
                        sgbdProduto.add(produto);
                    }
                }
            }
        }
        return sgbdProduto;
    }

    @Override
    public List<Produto> findAll() {
        return sgbdProdutoInit().stream().collect(Collectors.toList());

    }

    public Produto getProdutoByCodigo(int codigo) {
        Produto produto = null;

        for (Solicitante solicitante : solicitanteService.findAll()) {
            if (solicitante.getPedidos() != null) {
                for (Pedido pedido : solicitante.getPedidos()) {
                    for (Produto produtoTemp : pedido.getProdutos()) {
                        if (produtoTemp.getCodigo() == codigo) {
                            return produto = produtoTemp;

                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
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



