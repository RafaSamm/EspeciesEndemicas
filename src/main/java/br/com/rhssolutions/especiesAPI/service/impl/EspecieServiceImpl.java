package br.com.rhssolutions.especiesAPI.service.impl;

import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.dto.EspecieMapper;
import br.com.rhssolutions.especiesAPI.exception.EspecieNotFoundException;
import br.com.rhssolutions.especiesAPI.repository.EspecieRepository;
import br.com.rhssolutions.especiesAPI.service.EspecieService;
import br.com.rhssolutions.especiesAPI.service.client.AesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        especies.stream()
                .filter(especie -> !especieRepository.existsByNomeCientifico(especie.getNomeCientifico()))
                .forEach(especieRepository::save);

        return especies;
    }

    @Transactional(rollbackFor = Exception.class) //Caso de falha na chamada da API externa - rollback automático
    public Especie buscarEspecieAleatoria() {
        var especie = EspecieMapper.toDomain(aesClient.getRandomEspecie());
        return especieRepository.save(especie);
    }


    @Override
    @Transactional(readOnly = true)  //evitando locks(travas no banco) desnecessários
    public Iterable<Especie> listaTodasAsEspecies() {
        var especies = especieRepository.findAll();
        if (especies.iterator().hasNext()) {
            return especies;
        } else {
            throw new EspecieNotFoundException("Nao ha especies cadastradas");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Especie> buscarEspeciePorId(Long id) {
        return Optional.ofNullable(especieRepository.findById(id)
                .orElseThrow(() -> new EspecieNotFoundException("Especie nao encontrada com o id: " + id)));
    }
}
