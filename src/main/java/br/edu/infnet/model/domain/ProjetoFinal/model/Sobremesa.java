package br.edu.infnet.model.domain.ProjetoFinal.model;

public class Sobremesa extends Produto{
    //mudei de float para long
    private float quantidade;

    private boolean doce;

    private String informacao;
    //mudei de float para long

    public Sobremesa(String nome, float valor, int codigo,String tipo,float quantidade,boolean doce,String informacao) {
        super(nome, valor, codigo,tipo);
        this.quantidade = quantidade;
        this.doce = doce;
        this.informacao = informacao;

    }

    //mudei de float para long
    public Sobremesa(float quantidade,boolean doce,String informacao) {
        this.quantidade = quantidade;
        this.doce = doce;
        this.informacao = informacao;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public boolean isDoce() {
        return doce;
    }

    public String getInformacao() {
        return informacao;
    }
    public double preçoTotal(){

       return this.getValor()*this.getQuantidade();
    }

    @Override
    String consultarProduto() {
        StringBuilder sb = new StringBuilder();

        sb.append("O produto é: " + this.doce);
        sb.append("O preço total é: " + this.preçoTotal());
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Sobremesa{" +
                "quantidade=" + quantidade +
                ", doce=" + doce +
                ", informacao='" + informacao + '\'' +
                "Preço total é: " + consultarProduto() +
                '}';
    }
}
