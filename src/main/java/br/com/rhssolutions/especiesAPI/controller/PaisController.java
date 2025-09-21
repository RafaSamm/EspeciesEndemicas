package br.com.rhssolutions.especiesAPI.controller;

import br.com.rhssolutions.especiesAPI.domain.Pais;
import br.com.rhssolutions.especiesAPI.service.impl.PaisServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisServiceImpl paisServiceImpl;

    public PaisController(PaisServiceImpl paisServiceImpl) {
        this.paisServiceImpl = paisServiceImpl;
    }

    @PostMapping("/sincronizar")
    public ResponseEntity<List<Pais>> sincronizarPaises() {
        var paises = paisServiceImpl.buscarESalvarTodosPaises();
        return ResponseEntity.ok(paises);

    }
}
