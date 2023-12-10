package br.edu.infnet.model.domain.ProjetoFinal.Exceptions;

public class ProdutoValorInvalidoException extends Exception{


    private float valor;

    public ProdutoValorInvalidoException(float valor){
        this.valor = valor;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Valor tem que ser maior que 0. Seu valor: ");
        sb.append(this.valor);

        return sb.toString();

    }
}
