package br.com.rhssolutions.especiesAPI.dto;


import br.com.rhssolutions.especiesAPI.domain.CodigoIso;
import br.com.rhssolutions.especiesAPI.domain.Pais;

public class PaisMapper {

    public static Pais toDomain(PaisDTO paisDTO) { // DTO para domínio
        var pais = new Pais();
        pais.setNome(paisDTO.getName());
        pais.setIsoCode(paisDTO.getIsoCode());

        return pais;
    }

    public static PaisDTO toPaisDTO(String isoCode) {
        CodigoIso codigoIso1 = CodigoIso.fromString(isoCode);

        var paisDTO = new PaisDTO();
        paisDTO.setName(codigoIso1.getPais());
        paisDTO.setIsoCode(isoCode);
        return paisDTO;
    }


}
