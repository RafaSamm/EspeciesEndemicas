package br.com.rhssolutions.especiesAPI.repository;

import br.com.rhssolutions.especiesAPI.domain.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Long> {

    Boolean existsByNomeCientifico(String nomeCientifico);

}
