package br.edu.ifpb.umbumaker.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.LocalArmazenamentoService;
import br.edu.ifpb.umbumaker.model.LocalArmazenamento;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/localArmazenamento")
public class LocalArmazenamentoController {

    @Autowired
    private LocalArmazenamentoService localArmazenamentoService;

    @PostMapping
    public ResponseEntity<LocalArmazenamento> criarLocalArmazenamento(@RequestBody LocalArmazenamento localArmazenamento) {
    	LocalArmazenamento novoLocalArmazenamento = localArmazenamentoService.criarLocalArmazenamento(localArmazenamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLocalArmazenamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalArmazenamento> atualizarLocalArmazenamento(@PathVariable Long codigo, @RequestBody LocalArmazenamento insumo) {
        try {
        	LocalArmazenamento insumoAtualizado = localArmazenamentoService.atualizarLocalArmazenamento(codigo, insumo);
            return ResponseEntity.ok(insumoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocalArmazenamento(@PathVariable Long codigo) {
        try {
        	localArmazenamentoService.deletarLocalArmazenamento(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<LocalArmazenamento>> listarLocalArmazenamentos() {
        List<LocalArmazenamento> insumos = localArmazenamentoService.listarLocalArmazenamentos();
        return ResponseEntity.ok(insumos);
    }

}