package br.edu.infnet.model.domain.ProjetoFinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private static int num = 1;
    private int id = 1;
    private String descricao;


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataInicial = LocalDateTime.now();

    private boolean web;

    private List<Produto> produtos;

    public Pedido() {
        id++;
    }

    public Pedido(String descricao, boolean web, List<Produto> produtos) {
        this.descricao = descricao;
        this.web = web;
        this.dataInicial = LocalDateTime.now();
        this.produtos = produtos;
        this.id = num++;


    }


    public Pedido(String descricao, List<Produto> produtos) {
        this.descricao = descricao;
        this.dataInicial = LocalDateTime.now();
        this.produtos = produtos;
        this.id = num++;

    }


    public int getId(){
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public boolean isWeb() {
        return web;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", web=" + web +
                ", produtos=" + produtos +
                '}';
    }
}
