package br.com.rhssolutions.especiesAPI.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum CodigoIso {

    CN("China"),
    TZ("Tanzânia"),
    ZA("África do Sul"),
    MX("México"),
    EC("Equador"),
    BR("Brasil"),
    MG("Madagáscar"),
    CR("Costa Rica"),
    MU("Maurício"),
    NZ("Nova Zelândia"),
    US("Estados Unidos"),
    KE("Quênia"),
    BD("Bangladesh"),
    AU("Austrália"),
    MM("Mianmar"),
    IN("Índia"),
    CD("República Democrática do Congo"),
    JP("Japão"),
    SC("Seicheles"),
    CO("Colômbia"),
    ET("Etiópia"),
    SB("Ilhas Salomão"),
    PE("Peru"),
    HN("Honduras"),
    VU("Vanuatu"),
    CL("Chile"),
    CU("Cuba"),
    PA("Panamá"),
    CA("Canadá"),
    ID("Indonésia"),
    GR("Grécia"),
    YE("Iémen"),
    IT("Itália"),
    NA("Namíbia"),
    BZ("Belize"),
    VN("Vietnã"),
    PR("Porto Rico"),
    PH("Filipinas"),
    LK("Sri Lanka"),
    CV("Cabo Verde"),
    UNKNOWN("País desconhecido");

    private final String pais;

    CodigoIso(String pais) {
        this.pais = pais;
    }

    @JsonCreator
    public static CodigoIso fromString(String value) {
        for (CodigoIso codigoIso : CodigoIso.values()) {
            if (codigoIso.name().equalsIgnoreCase(value)) {
                return codigoIso;
            }
        }
        return UNKNOWN;
    }

}



