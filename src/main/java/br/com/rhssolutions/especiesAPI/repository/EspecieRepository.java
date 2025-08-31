package br.com.rhssolutions.especiesAPI.repository;

import br.com.rhssolutions.especiesAPI.domain.CodigoIso;
import br.com.rhssolutions.especiesAPI.domain.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspecieRepository extends JpaRepository<Especie, Long> {

    List<Especie> findByCodigoIso(CodigoIso codigoIso);
}
