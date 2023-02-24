package com.sofka.serviciosRest.retoPracticoServiciosRest.controller;


import com.sofka.serviciosRest.retoPracticoServiciosRest.entity.Afiliados;
import com.sofka.serviciosRest.retoPracticoServiciosRest.repository.AfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/afiliados")
public class AfiliadosController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @GetMapping
    public List<Afiliados> obtenerAfiliados() {
        return afiliadoRepository.findAll();
    }

    @GetMapping(params = "cedula")
    public ResponseEntity<Object> obtenerAfiliadoPorCedula(@RequestParam String cedula) {
        Optional<Object> afiliado = afiliadoRepository.findByCedula(cedula);
        return afiliado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Afiliados> crearAfiliado(@RequestBody Afiliados afiliado) {
        if (afiliadoRepository.findByCedula(afiliado.getCedula()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Afiliados nuevoAfiliado = afiliadoRepository.save(afiliado);
        return ResponseEntity.created(URI.create("/api/afiliados/" + nuevoAfiliado.getIdAfiliado())).body(nuevoAfiliado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Afiliados> actualizarAfiliado(@PathVariable Long id, @RequestBody Afiliados afiliado) {
        Optional<Afiliados> afiliadoExistente = afiliadoRepository.findById(id);
        if (!afiliadoExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Afiliados afiliadoActualizado = afiliadoExistente.get();
        afiliadoActualizado.setNombre(afiliado.getNombre());
        afiliadoActualizado.setApellido(afiliado.getApellido());
        afiliadoActualizado.setCedula(afiliado.getCedula());
        afiliadoActualizado.setEmpresaId(afiliado.getEmpresaId());
        afiliadoRepository.save(afiliadoActualizado);
        return ResponseEntity.ok(afiliadoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAfiliado(@PathVariable Long id) {
        if (!afiliadoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        afiliadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
