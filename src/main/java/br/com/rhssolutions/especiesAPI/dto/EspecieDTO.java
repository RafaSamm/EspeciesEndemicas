package br.com.rhssolutions.especiesAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EspecieDTO {

    //Da API externa

    @JsonProperty("common_name")
    private String commonName;

    @JsonProperty("scientific_name")
    private String scientificName;

    @JsonProperty("conservation_status")
    private String conservationStatus;

    private String group;

    @JsonProperty("iso_code")
    private String isoCode;

    private String image;

    @JsonProperty("country")
    private PaisDTO country;


}
