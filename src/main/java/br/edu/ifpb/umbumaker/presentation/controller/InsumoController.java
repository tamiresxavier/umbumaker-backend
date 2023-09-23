package br.edu.ifpb.umbumaker.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.InsumoService;
import br.edu.ifpb.umbumaker.model.Insumo;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/insumo")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @PostMapping
    public ResponseEntity<Insumo> criarInsumo(@RequestBody Insumo insumo) {
    	Insumo novoInsumo = insumoService.criarInsumo(insumo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoInsumo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insumo> atualizarInsumo(@PathVariable Long codigo, @RequestBody Insumo insumo) {
        try {
        	Insumo insumoAtualizado = insumoService.atualizarInsumo(codigo, insumo);
            return ResponseEntity.ok(insumoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarInsumo(@PathVariable Long codigo) {
        try {
        	insumoService.deletarInsumo(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Insumo>> listarInsumos() {
        List<Insumo> insumos = insumoService.listarInsumos();
        return ResponseEntity.ok(insumos);
    }

}