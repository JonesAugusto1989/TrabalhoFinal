package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.Bebida;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IBebidaService {

    public List<Bebida> findAll();

    public void delete(@PathVariable int codigo);
}
