package br.com.rhssolutions.especiesAPI.controller;

import br.com.rhssolutions.especiesAPI.domain.Pais;
import br.com.rhssolutions.especiesAPI.service.impl.PaisServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisServiceImpl paisServiceImpl;

    public PaisController(PaisServiceImpl paisServiceImpl) {
        this.paisServiceImpl = paisServiceImpl;
    }

    @PostMapping("/sincronizar")
    public ResponseEntity<List<Pais>> sincronizarPaises() {
        var paises = paisServiceImpl.sincronizarPaises();
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Pais>> listarTodosOsPaises() {
        var paises = paisServiceImpl.listarTodosOsPaises();
        return ResponseEntity.ok(paises);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Pais>> buscarPaisPorId(@PathVariable Long id) {
        return ResponseEntity.ok(paisServiceImpl.buscarPaisPorId(id));
    }
}
