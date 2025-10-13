package br.com.rhssolutions.especiesAPI.domain.pais;


import br.com.rhssolutions.especiesAPI.dto.PaisDTO;
import br.com.rhssolutions.especiesAPI.dto.PaisMapper;
import br.com.rhssolutions.especiesAPI.repository.PaisRepository;
import br.com.rhssolutions.especiesAPI.service.client.AesClient;
import br.com.rhssolutions.especiesAPI.service.impl.PaisServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static br.com.rhssolutions.especiesAPI.common.PaisFactory.sincronizaPaisValido;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaisServiceTest {

    @InjectMocks
    private PaisServiceImpl paisService;

    @Mock
    private AesClient aesClient;

    @Mock
    private PaisRepository paisRepository;


    @Test
    public void sincronizarAPIValidaComPaises() {
        PaisDTO paisDTO = sincronizaPaisValido();
        // Cria o objeto final convertido — o mesmo que o método salvaria
        var paisConvertido = PaisMapper.toDomain(PaisMapper.toPaisDTO("BR"));

        when(aesClient.getAllCountries()).thenReturn(List.of("BR", "US")); //Retorno da API externa
        when(paisRepository.count()) //Banco ainda não tem países
                .thenReturn(0L)
                .thenReturn(1L);
        when(paisRepository.saveAll(anyList() //Salva o país convertido
        )).thenReturn(List.of(paisConvertido));


        var sut = paisService.sincronizarPaises();

        assertThat(sut).isNotEmpty();
        assertThat(sut).hasSize(1);
        assertThat(sut.getFirst().getIsoCode()).isEqualTo("BR");
        assertThat(sut.getFirst().getNome()).isEqualTo("Brasil");


        verify(aesClient, times(1)).getAllCountries();
        verify(paisRepository, times(1)).saveAll(anyList());
    }


}
