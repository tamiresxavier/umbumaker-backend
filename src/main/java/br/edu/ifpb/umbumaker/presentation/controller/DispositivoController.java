package br.edu.ifpb.umbumaker.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.DispositivoService;
import br.edu.ifpb.umbumaker.model.Dispositivo;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/dispositivo")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping
    public ResponseEntity<Dispositivo> criarDispositivo(@RequestBody Dispositivo dispositivo) {
    	Dispositivo novoDispositivo = dispositivoService.criarDispositivo(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDispositivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> atualizarContaAcesso(@PathVariable Long codigo, @RequestBody Dispositivo dispositivo) {
        try {
        	Dispositivo dispositivoAtualizado = dispositivoService.atualizarDispositivo(codigo, dispositivo);
            return ResponseEntity.ok(dispositivoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContaAcesso(@PathVariable Long codigo) {
        try {
        	dispositivoService.deletarDispositivo(codigo);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

   
    @GetMapping
    public ResponseEntity<List<Dispositivo>> listarDispositivos() {
        List<Dispositivo> dispositivos = dispositivoService.listarDispositivos();
        return ResponseEntity.ok(dispositivos);
    }

}