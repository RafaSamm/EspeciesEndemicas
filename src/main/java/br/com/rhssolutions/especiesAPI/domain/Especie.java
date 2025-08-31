package br.com.rhssolutions.especiesAPI.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_especie")
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_comum")
    private String nomeComum;

    @Column(name = "nome_cientifico")
    private String nomeCientifico;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_conservacao")
    private Status statusConservacao;

    @Column(name = "grupo")
    private String grupo;

    @Enumerated(EnumType.STRING)
    @Column(name = "codigo_iso")
    private CodigoIso codigoIso;

}
