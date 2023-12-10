package br.edu.infnet.model.domain.ProjetoFinal.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComidaException extends Exception {
    Logger logger = LoggerFactory.getLogger(ComidaException.class);

    private float peso;
    public ComidaException(float peso) {
        this.peso = peso;
    }



    public String toString() {

        logger.info("Peso da comida invalido precisa ser maior que 0");
        StringBuilder sb = new StringBuilder();
        sb.append("Peso da comida invalido precisa ser maior que 0.");
        sb.append("Seu peso: ");
        sb.append(this.peso);

        return sb.toString();
    }
}
