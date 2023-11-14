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

import br.edu.ifpb.umbumaker.business.service.EntradaEstoqueService;
import br.edu.ifpb.umbumaker.model.EntradaEstoque;
import jakarta.persistence.EntityNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/entradaestoque")
public class EntradaEstoqueController {

    @Autowired
    private EntradaEstoqueService entradaEstoqueService;

    @PostMapping
    public ResponseEntity<EntradaEstoque> criarEntradaEstoque(@RequestBody EntradaEstoque entradaEstoque) {
    	EntradaEstoque novoEntradaEstoque = entradaEstoqueService.criarEntradaEstoque(entradaEstoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEntradaEstoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaEstoque> atualizarEntradaEstoque(@PathVariable(value = "id") Long codigo, @RequestBody EntradaEstoque entradaEstoque) {
        try {
        	EntradaEstoque entradaEstoqueAtualizado = entradaEstoqueService.atualizarEntradaEstoque(codigo, entradaEstoque);
            return ResponseEntity.ok(entradaEstoqueAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntradaEstoque(@PathVariable(value = "id") Long codigo) {
        try {
        	entradaEstoqueService.deletarEntradaEstoque(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EntradaEstoque>> listarEntradaEstoques() {
        List<EntradaEstoque> entradaEstoques = entradaEstoqueService.listarEntradaEstoques();
        return ResponseEntity.ok(entradaEstoques);
    }

}