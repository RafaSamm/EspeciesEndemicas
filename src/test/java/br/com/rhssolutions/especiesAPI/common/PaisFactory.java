package br.com.rhssolutions.especiesAPI.common;

import br.com.rhssolutions.especiesAPI.dto.PaisDTO;

public class PaisFactory {

    public static PaisDTO sincronizaPaisValido() {
        var pais = new PaisDTO();
        pais.setIsoCode("BR");
        pais.setName("Brasil");
        return pais;
    }
}
