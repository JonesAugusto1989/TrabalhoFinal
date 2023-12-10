package br.edu.infnet.model.domain.ProjetoFinal.Exceptions;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class PedidoException extends Exception{
    Logger logger = LoggerFactory.getLogger(PedidoException.class);
    private int id;

    public PedidoException(int id) {

        this.id = id;
    }

    public String toString() {

        logger.info("Id do pedido não encontrado");
        logger.info("O Id do pedido é invalido/ não foi encontrado");
        StringBuilder sb = new StringBuilder();
        sb.append("O Id da pedido não foi encontrado");
        sb.append("Id pesquisado: ");
        sb.append(this.id);

        return sb.toString();
    }
}
