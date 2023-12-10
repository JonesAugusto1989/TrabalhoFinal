package br.edu.infnet.model.domain.ProjetoFinal.model;

import java.util.List;

public class Solicitante {
    private int id = 1;
    private static int num = 1;
    private String nome;

    private String cpf;

    private String email;

    List<Pedido> pedidos;

    public int getId() {
        return id;
    }


    public Solicitante() {

    }
    public Solicitante(String nome, String cpf, String email) {


        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.pedidos = pedidos;
        this.id = num++;


    }
    public Solicitante(String nome, String cpf, String email, List<Pedido> pedidos) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.pedidos = pedidos;
        this.id = num++;
    }



    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getEmail() {
        return email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
