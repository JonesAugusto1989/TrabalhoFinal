package br.edu.infnet.model.domain.ProjetoFinal.model;

public class Bebida extends Produto{

    private boolean gelada;
    private float tamanho;
    private String marca;

    public Bebida(String nome, float valor, int codigo,String tipo,boolean gelada,float tamanho,String marca) {

        super(nome, valor, codigo,tipo);
        this.gelada = gelada;
        this.tamanho = tamanho;
        this.marca = marca;
    }
    public Bebida(boolean gelada,float tamanho,String marca){
        this.gelada = gelada;
        this.tamanho = tamanho;
        this.marca = marca;
    }


    public boolean isGelada() {
        return gelada;
    }

    public float getTamanho() {
        return tamanho;
    }

    public String getMarca() {
        return marca;
    }


    @Override
    String consultarProduto() {
        StringBuffer sb = new StringBuffer();
        sb.append("O produto é: " + this.getNome());
        sb.append("A marca é: " + this.getMarca());
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "gelada=" + gelada +
                ", tamanho=" + tamanho +
                ", marca='" + marca + '\'' +
                '}';
    }
}
