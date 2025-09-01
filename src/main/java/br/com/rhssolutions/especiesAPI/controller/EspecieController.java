package br.com.rhssolutions.especiesAPI.controller;

import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.service.EspecieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especies")
public class EspecieController {

    private final EspecieService especieService;

    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @PostMapping("/sincronizar")
    public ResponseEntity<List<Especie>> sincronizarEspecies() {
        List<Especie> especies = especieService.sincronizarEspecies();
        return ResponseEntity.ok(especies);
    }

    @PostMapping("/busca")
    public ResponseEntity<Especie> buscarEspecieAleatoria() {
        var especie = especieService.buscarEspecieAleatoria();
        return ResponseEntity.ok(especie);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Especie>> listarEspecies() {
        List<Especie> especies = especieService.listarEspecies();
        return ResponseEntity.ok(especies);
    }


}
