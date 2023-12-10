package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.Comida;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IComidaService {

    public List<Comida> findAll();

    public void delete(@PathVariable int codigo);
}
