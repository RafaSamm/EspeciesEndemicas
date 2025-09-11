package br.com.rhssolutions.especiesAPI.service.impl;

import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.dto.EspecieMapper;
import br.com.rhssolutions.especiesAPI.repository.EspecieRepository;
import br.com.rhssolutions.especiesAPI.service.EspecieService;
import br.com.rhssolutions.especiesAPI.service.client.AesClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EspecieServiceImpl implements EspecieService {

    private final AesClient aesClient;
    private final EspecieRepository especieRepository;

    @Transactional
    public List<Especie> sincronizarEspecies() {
        List<Especie> especies = aesClient.getAllEspecies()
                .stream().map(EspecieMapper::toDomain).toList();
        especieRepository.saveAll(especies);
        return especies;
    }


    @Transactional(rollbackOn = Exception.class)
    public Especie buscarEspecieAleatoria() {
        var especie = EspecieMapper.toDomain(aesClient.getRandomEspecie());
        especieRepository.save(especie);
        return especie;
    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public Iterable<Especie> listaTodasAsEspecies() {
        var especies = especieRepository.findAll();
        if (especies.iterator().hasNext()) {
            return especies;
        } else {
            throw new RuntimeException("Nenhuma especie encontrada");
        }


    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Optional<Especie> buscarEspeciePorId(Long id) {
        var especie = especieRepository.findById(id);
        if (especie.isPresent()) {
            return especie;
        } else {
            throw new RuntimeException("Especie não encontrada");
        }

    }
}
