package br.com.rhssolutions.especiesAPI.service;

import br.com.rhssolutions.especiesAPI.client.AesClient;
import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.dto.EspecieMapper;
import br.com.rhssolutions.especiesAPI.repository.EspecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecieService {

    private final AesClient aesClient;
    private final EspecieRepository especieRepository;

    public List<Especie> sincronizarEspecies() {
        List<Especie> especies = aesClient.getAllEspecies()
                .stream().map(EspecieMapper::toDomain).toList();
        especieRepository.saveAll(especies);
        return especies;
    }

    public List<Especie> listarEspecies() {
        return especieRepository.findAll();
    }

    public Especie buscarEspecieAleatoria() {
        var especie = EspecieMapper.toDomain(aesClient.getRandomEspecie());
        especieRepository.save(especie);
        return especie;
    }

}
