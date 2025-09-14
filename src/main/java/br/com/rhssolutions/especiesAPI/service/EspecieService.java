package br.com.rhssolutions.especiesAPI.service;

import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.dto.EspecieDTO;

import java.util.Optional;

public interface EspecieService {

    Iterable<Especie> listaTodasAsEspecies();

    Optional<Especie> buscarEspeciePorId(Long id);

}
