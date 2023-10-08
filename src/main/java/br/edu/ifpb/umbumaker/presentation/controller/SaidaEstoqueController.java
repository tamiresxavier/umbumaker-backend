package br.edu.ifpb.umbumaker.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.umbumaker.business.service.SaidaEstoqueService;
import br.edu.ifpb.umbumaker.model.SaidaEstoque;
import jakarta.persistence.EntityNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/saidaestoque")
public class SaidaEstoqueController {

    @Autowired
    private SaidaEstoqueService saidaEstoqueService;

    @PostMapping
    public ResponseEntity<SaidaEstoque> criarSaidaEstoque(@RequestBody SaidaEstoque saidaEstoque) {
    	SaidaEstoque novaSaidaEstoque = saidaEstoqueService.criarSaidaEstoque(saidaEstoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSaidaEstoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaidaEstoque> atualizarSaidaEstoque(@PathVariable Long codigo, @RequestBody SaidaEstoque saidaEstoque) {
        try {
        	SaidaEstoque saidaEstoqueAtualizado = saidaEstoqueService.atualizarSaidaEstoque(codigo, saidaEstoque);
            return ResponseEntity.ok(saidaEstoqueAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSaidaEstoque(@PathVariable Long codigo) {
        try {
        	saidaEstoqueService.deletarSaidaEstoque(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SaidaEstoque>> listarSaidaEstoques() {
        List<SaidaEstoque> saidaEstoques = saidaEstoqueService.listarSaidaEstoques();
        return ResponseEntity.ok(saidaEstoques);
    }

}