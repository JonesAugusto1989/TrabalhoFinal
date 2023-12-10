package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.Sobremesa;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ISobremesaService {

    public List<Sobremesa> findAll();

    public void delete(@PathVariable int codigo);
}
