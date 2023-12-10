package br.edu.infnet.model.domain.ProjetoFinal.Exceptions;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class SobremesaException extends Exception{
    Logger logger = LoggerFactory.getLogger(SobremesaException.class);
    private int id;

    public SobremesaException(int id) {

        this.id = id;
    }

    public String toSring() {

        logger.info("Id da Sobremesa não encontrada");
        logger.info("O Id da sobremesa não foi encontrada");
        StringBuilder sb = new StringBuilder();
        sb.append("O Id da sobremesa não foi encontrada");
        sb.append("Id pesquisado: ");
        sb.append(this.id);

        return sb.toString();

    }
}
