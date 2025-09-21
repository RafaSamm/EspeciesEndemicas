package br.com.rhssolutions.especiesAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaisDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("iso_code")
    private String isoCode;
}
