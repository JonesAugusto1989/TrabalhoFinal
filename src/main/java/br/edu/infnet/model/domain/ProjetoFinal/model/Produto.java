package br.edu.infnet.model.domain.ProjetoFinal.model;

import br.edu.infnet.model.domain.ProjetoFinal.model.Deserialize.ProdutoDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ProdutoDeserialize.class)
public abstract class Produto{

    private String nome;

    private float valor;

    private int codigo;
    private String tipo;

    public Produto(String nome, float valor, int codigo,String Tipo) {

        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
        this.tipo = tipo;
    }
    public Produto() {

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    abstract String consultarProduto();

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
