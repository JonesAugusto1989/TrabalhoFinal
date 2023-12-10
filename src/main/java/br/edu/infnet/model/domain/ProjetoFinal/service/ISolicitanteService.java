package br.edu.infnet.model.domain.ProjetoFinal.service;

import br.edu.infnet.model.domain.ProjetoFinal.model.Solicitante;

import java.util.List;

public interface ISolicitanteService {

    List<Solicitante> findAll();

    void delete(int id);

    void create(Solicitante solicitante);

    void update(int id, Solicitante solicitante);
}
