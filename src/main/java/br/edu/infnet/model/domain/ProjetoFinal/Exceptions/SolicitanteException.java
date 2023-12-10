package br.edu.infnet.model.domain.ProjetoFinal.Exceptions;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class SolicitanteException extends Exception{
    Logger logger = LoggerFactory.getLogger(SolicitanteException.class);
    private int id;

    public SolicitanteException(int id) {

        this.id = id;
    }


    public void SolicitanteException() {

        logger.info("O Id para esse solicitante não encontrado");

    }
    public String toString() {

        logger.info("O Id para esse solicitante não encontrado");
        StringBuilder sb = new StringBuilder();
        sb.append("O Id para esse solicitante não encontrado");
        sb.append("Id pesquisado: ");
        sb.append(this.id);

        return sb.toString();
    }
}
