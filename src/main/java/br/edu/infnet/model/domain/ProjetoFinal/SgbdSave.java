package br.edu.infnet.model.domain.ProjetoFinal;

import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;
import br.edu.infnet.model.domain.ProjetoFinal.service.SolicitanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SgbdSave implements ApplicationRunner {
    @Autowired
    SolicitanteService solicitanteService;
    Logger logger = LoggerFactory.getLogger("SgbdSave.class");
    File file = new File("\\C:\\Estudo\\Java\\ProjetoFinal\\src\\main\\java\\br\\edu\\infnet\\model\\domain\\ProjetoFinal\\Files\\Backup.csv");

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (file.exists()) {
            try (FileWriter backup = new FileWriter(file)) {
                for (Solicitante solicitante : solicitanteService.findAll()) {
                    writeToFile(solicitante, backup);
                }
            } catch (IOException e) {
                logger.info("Ocorreu um erro de I/O");
            }
        } else{
            try {
                if (file.createNewFile()) {
                    logger.info("O arquivo foi criado com sucesso.");
                } else {
                    logger.info("Algum erro impossibilitou a criação do arquivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void writeToFile(Solicitante solicitante, FileWriter backup) throws IOException {
        backup.write(solicitante.toString() + "\n");
    }

}
