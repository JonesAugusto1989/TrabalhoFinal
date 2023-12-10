package br.edu.infnet.model.domain.ProjetoFinal;

import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import br.edu.infnet.model.domain.ProjetoFinal.service.SolicitanteService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SolicitanteTestes {
Logger logger = LoggerFactory.getLogger(SolicitanteTestes.class);
    @Autowired
    SolicitanteService solicitanteService;


    Solicitante solicitante = new Solicitante("Usuario 1", "3333333333", "usuario1@email.com");
    Solicitante solicitante2 = new Solicitante("Usuario 2", "44444444", "usuario2@email.com");
    Solicitante solicitante3 = new Solicitante("Usuario 3", "55555555555555", "usuario3@email.com");

@Test
    public void cadastrarSolicitantes() {
        solicitanteService.create(solicitante);
        solicitanteService.create(solicitante2);
        solicitanteService.create(solicitante3);
    }
}
