package br.com.rhssolutions.especiesAPI.service.impl;

import br.com.rhssolutions.especiesAPI.domain.Pais;
import br.com.rhssolutions.especiesAPI.dto.PaisMapper;
import br.com.rhssolutions.especiesAPI.exception.PaisNotFoundException;
import br.com.rhssolutions.especiesAPI.repository.PaisRepository;
import br.com.rhssolutions.especiesAPI.service.PaisService;
import br.com.rhssolutions.especiesAPI.service.client.AesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    private final AesClient aesClient;
    private final PaisRepository paisRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Pais> sincronizarPaises() {
        //Buscando ISO codes da API externa
        var isoCodes = aesClient.getAllCountries();

        if (isoCodes.isEmpty()) {
            throw new PaisNotFoundException("Não foi possível buscar os países na API externa");
        }
        //Verifica se os países já estão cadastrados no banco
        if (paisRepository.count() == isoCodes.size()) {
            throw new PaisNotFoundException("Os países já estão cadastrados no banco de dados");
        }

        //Conversão de ISO codes - PaisDTO - Entidade
        List<Pais> paises = isoCodes.stream().map(PaisMapper::toPaisDTO)
                .map(PaisMapper::toDomain).toList();
        //Salva no banco
        return paisRepository.saveAll(paises);
    }

    @Override
    public Iterable<Pais> listarTodosOsPaises() {
        var paises = paisRepository.findAll();
        if (paises.iterator().hasNext()) {
            return paises;
        } else {
            throw new PaisNotFoundException("Não há países cadastrados no banco de dados");
        }
    }

    @Override
    public Optional<Pais> buscarPaisPorId(Long id) {
        return Optional.ofNullable(paisRepository.findById(id)
                .orElseThrow(() -> new PaisNotFoundException("Pais nao encontrado com o id: " + id)));
    }
}
