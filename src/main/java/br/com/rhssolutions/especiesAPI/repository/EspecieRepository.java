package br.com.rhssolutions.especiesAPI.repository;

import br.com.rhssolutions.especiesAPI.domain.CodigoIso;
import br.com.rhssolutions.especiesAPI.domain.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

import java.util.List;
import java.util.Optional;

public interface EspecieRepository extends JpaRepository<Especie, Long> {

    List<Especie> findByCodigoIso(CodigoIso codigoIso);

}
