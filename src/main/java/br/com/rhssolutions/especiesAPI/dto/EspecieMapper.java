package br.com.rhssolutions.especiesAPI.dto;

import br.com.rhssolutions.especiesAPI.domain.CodigoIso;
import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.domain.Status;

public class EspecieMapper {

    public static Especie toDomain(EspecieDTO dto) {//Converte DTO para Domain
        var especie = new Especie();
        especie.setNomeComum(dto.getCommonName());
        especie.setNomeCientifico(dto.getScientificName());
        especie.setGrupo(dto.getGroup());
        especie.setImagem(dto.getImage());

        //Converter o ISO code para o enum
        especie.setCodigoIso(CodigoIso.fromString(dto.getIsoCode())); //String para Enum

        //Converter o status de conservação para o enum
        especie.setStatusConservacao(mapaStatus(dto.getConservationStatus()));

        return especie;
    }

    private static Status mapaStatus(String valor) {
        if (valor == null) return null;

        return switch (valor) {
            case "VU" -> Status.VULNERAVEL;
            case "EX" -> Status.EXTINTO;
            case "CR" -> Status.PERIGO_CRITICO;
            case "EN" -> Status.EM_PERIGO;
            case "EW" -> Status.EXTINCAO_NATUREZA;
            case "NT" -> Status.PROXIMO_AMEACA;
            case "LC" -> Status.POUCO_CONCERNS;
            case "DD" -> Status.DADOS_DEFICIENTES;
            case "NE" -> Status.NAO_AVALIADO;
            default -> throw new ExceptionMapperDTO("Status de conservação inválido: " + valor);
        };

    }


}
