package br.com.rhssolutions.especiesAPI.service;

import br.com.rhssolutions.especiesAPI.domain.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisService {

    List<Pais> sincronizarPaises();

    Iterable<Pais> listarTodosOsPaises();

    Optional<Pais> buscarPaisPorId(Long id);

}
