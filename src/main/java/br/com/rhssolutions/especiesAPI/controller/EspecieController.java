package br.com.rhssolutions.especiesAPI.controller;

import br.com.rhssolutions.especiesAPI.domain.Especie;
import br.com.rhssolutions.especiesAPI.domain.Pais;
import br.com.rhssolutions.especiesAPI.service.impl.EspecieServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/especies")
public class EspecieController {

    private final EspecieServiceImpl especieService;

    public EspecieController(EspecieServiceImpl especieService) {
        this.especieService = especieService;
    }

    @PostMapping("/sincronizar")
    public ResponseEntity<List<Especie>> sincronizarEspecies() {
        List<Especie> especies = especieService.sincronizarEspecies();
        return ok().body(especies);
    }

    @PostMapping("/busca")
    public ResponseEntity<Especie> buscarEspecieAleatoria() {
        var especie = especieService.buscarEspecieAleatoria();
        return ok(especie);
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Especie>> listarTodasEspecies() {
        var especies = especieService.listaTodasAsEspecies();
        return ok(especies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Especie>> buscaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(especieService.buscarEspeciePorId(id));
    }


}
