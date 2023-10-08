package br.edu.ifpb.umbumaker.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.ZonaTrabalhoService;
import br.edu.ifpb.umbumaker.model.ZonaTrabalho;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/zonaTrabalho")
public class ZonaTrabalhoController {

    @Autowired
    private ZonaTrabalhoService zonaTrabalhoService;

    @PostMapping
    public ResponseEntity<ZonaTrabalho> criarZonaTrabalho(@RequestBody ZonaTrabalho zonaTrabalho) {
    	ZonaTrabalho novaZonaTrabalho = zonaTrabalhoService.criarZonaTrabalho(zonaTrabalho);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaZonaTrabalho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZonaTrabalho> atualizarZonaTrabalho(@PathVariable Long codigo, @RequestBody ZonaTrabalho zonaTrabalho) {
        try {
        	ZonaTrabalho zonaTrabalhoAtualizado = zonaTrabalhoService.atualizarZonaTrabalho(codigo, zonaTrabalho);
            return ResponseEntity.ok(zonaTrabalhoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarZonaTrabalho(@PathVariable Long codigo) {
        try {
        	zonaTrabalhoService.deletarZonaTrabalho(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ZonaTrabalho>> listarZonaTrabalhos() {
        List<ZonaTrabalho> zonaTrabalhos = zonaTrabalhoService.listarZonaTrabalhos();
        return ResponseEntity.ok(zonaTrabalhos);
    }

}