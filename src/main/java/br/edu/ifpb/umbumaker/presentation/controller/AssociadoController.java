package br.edu.ifpb.umbumaker.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.umbumaker.business.service.AssociadoService;
import br.edu.ifpb.umbumaker.model.Associado;
import br.edu.ifpb.umbumaker.presentation.dto.AssociadoContaAcessoDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService; 
	
	//converter para lista de dtos?
	@GetMapping("/associados")
    public ResponseEntity<Iterable<Associado>> listarAssociados(){
		Iterable<Associado> associados = associadoService.listarAssociados();
		return ResponseEntity.status(HttpStatus.OK).body(associados);
    }

	@PostMapping("/associados")
	public ResponseEntity<Object> criarAssociado(@RequestBody AssociadoContaAcessoDto associadoDto) {
		try {
			Associado associadoCriado = associadoService.criarAssociado(associadoDto.toModel());
			return new ResponseEntity<Object>(associadoCriado.toDto(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PatchMapping("/associados/{id}")
	public ResponseEntity<Object> atualizarAssociado(@PathVariable(value = "id") Long id,
			@RequestBody AssociadoContaAcessoDto associadoDto){
		try {			
			Associado associadoatualizado = associadoService.atualizarAssociado(id, associadoDto.toModel());
			return ResponseEntity.status(HttpStatus.OK).body(associadoatualizado.toDto());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/associados/{id}")
    public ResponseEntity<Object> deleteAssociado(@PathVariable(value = "id") Long id){
        
		associadoService.deletarAssociado(id);
        return ResponseEntity.status(HttpStatus.OK).body("Associado deletado com sulcesso.");
    }

}