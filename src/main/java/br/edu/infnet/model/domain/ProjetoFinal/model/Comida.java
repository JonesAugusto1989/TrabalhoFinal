package br.edu.infnet.model.domain.ProjetoFinal.model;

import java.util.Arrays;

public class Comida extends Produto{

    private float peso;
    private boolean vegano;
    private String[] ingredientes;

    public Comida(String nome, float valor, int codigo,String tipo,float peso,boolean vegano,String[]ingredientes) {

        super(nome, valor, codigo,tipo);
        this.peso = peso;
        this.vegano = vegano;
        this.ingredientes = ingredientes;
    }

    public Comida(float peso,boolean vegano,String[]ingredientes){
        this.peso = peso;
        this.vegano = vegano;
        this.ingredientes = ingredientes;

    }

    public float getPeso() {
        return peso;
    }

    public boolean isVegano() {
        return vegano;
    }



    @Override
    String consultarProduto() {

        StringBuilder sb = new StringBuilder();
        sb.append("O produto é: "+ this.getNome());
        sb.append("O valor é : "+this.getValor());
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Comida{" +
                "peso=" + peso +
                ", vegano=" + vegano +
                ", ingredientes=" + Arrays.toString(ingredientes) +
                '}';
    }
}
