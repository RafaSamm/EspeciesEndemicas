package br.com.rhssolutions.especiesAPI.common;

import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.dto.EspecieDTO;
import br.com.rhssolutions.especiesAPI.dto.PaisDTO;

public class EspecieFactory {

    public static EspecieDTO sincronizarEspecieValidaDTO() {
        EspecieDTO dto = new EspecieDTO();
        dto.setCommonName("Onça-pintada");
        dto.setScientificName("Panthera onca");
        dto.setGroup("Mamífero");
        dto.setIsoCode("BR");
        dto.setConservationStatus("VU");
        dto.setImage("onca.png");
        dto.setCountry(new PaisDTO());
        return dto;
    }

    public static Especie criarEspecie(Especie especie) {
        var especieSincronizada = new Especie();
        especieSincronizada.setNomeComum(especie.getNomeComum());
        especieSincronizada.setNomeCientifico(especie.getNomeCientifico());
        especieSincronizada.setStatusConservacao(especie.getStatusConservacao());
        especieSincronizada.setGrupo(especie.getGrupo());
        especieSincronizada.setCodigoIso(especie.getCodigoIso());
        especieSincronizada.setImagem(especie.getImagem());
        especieSincronizada.setPais(especie.getPais());
        return especieSincronizada;
    }


}

