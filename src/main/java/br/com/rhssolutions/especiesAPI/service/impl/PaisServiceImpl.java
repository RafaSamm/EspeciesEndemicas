package br.com.rhssolutions.especiesAPI.service.impl;

import br.com.rhssolutions.especiesAPI.domain.Pais;
import br.com.rhssolutions.especiesAPI.dto.PaisMapper;
import br.com.rhssolutions.especiesAPI.repository.PaisRepository;
import br.com.rhssolutions.especiesAPI.service.PaisService;
import br.com.rhssolutions.especiesAPI.service.client.AesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    private final AesClient aesClient;
    private final PaisRepository paisRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Pais> buscarESalvarTodosPaises() {
        //Buscando ISO codes da API externa
        var isoCodes = aesClient.getAllCountries();

        //Conversão de ISO codes - PaisDTO - Entidade
        List<Pais> paises = isoCodes.stream().map(PaisMapper::toPaisDTO)
                .map(PaisMapper::toDomain).toList();
        //Salva no banco
        return paisRepository.saveAll(paises);
    }
}
