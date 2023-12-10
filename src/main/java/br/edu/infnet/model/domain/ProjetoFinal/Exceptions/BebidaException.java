package br.edu.infnet.model.domain.ProjetoFinal.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BebidaException extends Exception{
    Logger logger = LoggerFactory.getLogger(BebidaException.class);
    private float tamanho;

    public BebidaException(float tamanho) {
this.tamanho = tamanho;
    }

    public String toString() {

        logger.info("Tamanho da bebida invalida.");

        logger.info("Tamanho precisa ser maior que zero.");
        StringBuilder sb = new StringBuilder();
        sb.append("Tamanho precisa ser maior que zero.");
        sb.append("Tamanho informado: ");
        sb.append(this.tamanho);

        return sb.toString();
    }

}
