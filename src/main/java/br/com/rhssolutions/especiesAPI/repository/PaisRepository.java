package br.com.rhssolutions.especiesAPI.repository;

import br.com.rhssolutions.especiesAPI.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    Optional<Pais> findByIsoCode(String isoCode);
}
