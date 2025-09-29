package br.com.rhssolutions.especiesAPI.domain.especie;

import br.com.rhssolutions.especiesAPI.dto.EspecieDTO;
import br.com.rhssolutions.especiesAPI.dto.EspecieMapper;
import br.com.rhssolutions.especiesAPI.exception.EspecieNotFoundException;
import br.com.rhssolutions.especiesAPI.repository.EspecieRepository;
import br.com.rhssolutions.especiesAPI.service.client.AesClient;
import br.com.rhssolutions.especiesAPI.service.impl.EspecieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static br.com.rhssolutions.especiesAPI.common.EspecieFactory.sincronizarEspecieValidaDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EspecieServiceTest {

    @InjectMocks
    private EspecieServiceImpl especieService;

    @Mock
    private AesClient aesClient;

    @Mock
    private EspecieRepository especieRepository;

    @Test
    public void sincronizarApiValidaComEspecies() {
        EspecieDTO especieDTO = sincronizarEspecieValidaDTO();
        var especieConvertida = EspecieMapper.toDomain(especieDTO);

        when(aesClient.getAllEspecies()).thenReturn(List.of(especieDTO));
        when(especieRepository.saveAll(anyList())).thenReturn(List.of(especieConvertida));

        var sut = especieService.sincronizarEspecies();

        assertThat(sut).isEqualTo(List.of(especieConvertida));
        assertThat(sut).isNotNull();

        // Verifica se o repository foi chamado
        verify(especieRepository, times(1)).saveAll(anyList());
    }

    @Test
    public void sincronizarApiInvalidaComEspecies() {
        when(aesClient.getAllEspecies()).thenThrow(new EspecieNotFoundException("API indisponível"));

        // Testando o service se está lançando a exceção
        assertThatThrownBy(() -> especieService.sincronizarEspecies())
                .isInstanceOf(EspecieNotFoundException.class)
                .hasMessageContaining("Erro ao sincronizar especies");

        //Verifica se o repository nunca foi chamado
        verify(especieRepository, never()).saveAll(anyList());

    }


}
