package br.edu.ifpb.umbumaker.presentation.controller;


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

import br.edu.ifpb.umbumaker.business.service.GestorService;
import br.edu.ifpb.umbumaker.model.Gestor;
import br.edu.ifpb.umbumaker.presentation.dto.GestorContaAcessoDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker")
public class GestorController {
	
	@Autowired
	private GestorService gestorService; 
	
	//converter para lista de dtos?
	@GetMapping("/gestores")
    public ResponseEntity<Iterable<Gestor>> listarGestor(){
		Iterable<Gestor> gestores = gestorService.listarGestor();
		return ResponseEntity.status(HttpStatus.OK).body(gestores);
    }	
	
//	@GetMapping("/{id}")
//    public ResponseEntity<Instructor> findById(@PathVariable (value = "id") Long id){
//        return instructorService.findById(id).map(instructor ->ResponseEntity.ok(instructor))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
    @GetMapping("name/{name}")
    public ResponseEntity<Iterable<Gestor>> getByName(@PathVariable("name") String nome){
    	Iterable<Gestor> gestores = gestorService.listarGestorPorNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(gestores);
    }
	
	
	@PostMapping("/gestores")
	public ResponseEntity<Object> criarGestor(@RequestBody GestorContaAcessoDto gestorDto) {
		try {
			Gestor gestorCriado = gestorService.criarGestor(gestorDto.toModel());
			return new ResponseEntity<Object>(gestorCriado.toDto(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/gestores/{id}")
	public ResponseEntity<Object> atualizarGestor(@PathVariable(value = "id") Long id,
			@RequestBody GestorContaAcessoDto gestorDto){
		try {			
			Gestor gestoratualizado = gestorService.atualizarGestor(id, gestorDto.toModel());
			return ResponseEntity.status(HttpStatus.OK).body(gestoratualizado.toDto());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/gestor/{id}")
    public ResponseEntity<Object> deleteGestor(@PathVariable(value = "id") Long id){
        
        gestorService.deletarGestor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Gestor deletado com sulcesso.");
    }
	
}