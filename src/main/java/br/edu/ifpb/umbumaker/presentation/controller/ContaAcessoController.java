package br.edu.ifpb.umbumaker.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.ContaAcessoService;
import br.edu.ifpb.umbumaker.model.ContaAcesso;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker/contasacesso")
public class ContaAcessoController {

    @Autowired
    private ContaAcessoService contaAcessoService;

  
    @PostMapping
    public ResponseEntity<ContaAcesso> criarContaAcesso(@RequestBody ContaAcesso contaAcesso) {
        ContaAcesso novaContaAcesso = contaAcessoService.criarContaAcesso(contaAcesso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaContaAcesso);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<ContaAcesso> atualizarContaAcesso(@PathVariable Long id, @RequestBody ContaAcesso contaAcesso) {
        try {
            ContaAcesso contaAcessoAtualizada = contaAcessoService.atualizarContaAcesso(id, contaAcesso);
            return ResponseEntity.ok(contaAcessoAtualizada);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContaAcesso(@PathVariable Long id) {
        try {
            contaAcessoService.deletarContaAcesso(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

   
    @GetMapping
    public ResponseEntity<List<ContaAcesso>> listarContasAcesso() {
        List<ContaAcesso> contasAcesso = contaAcessoService.listarContasAcesso();
        return ResponseEntity.ok(contasAcesso);
    }

}