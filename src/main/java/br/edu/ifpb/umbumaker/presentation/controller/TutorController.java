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

import br.edu.ifpb.umbumaker.business.service.TutorService;
import br.edu.ifpb.umbumaker.model.Tutor;
import br.edu.ifpb.umbumaker.presentation.dto.TutorContaAcessoDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/umbumaker")
public class TutorController {
	
	@Autowired
	private TutorService tutorService; 
	
	//converter para lista de dtos?
	@GetMapping("/tutores")
    public ResponseEntity<Iterable<Tutor>> listarTutor(){
		Iterable<Tutor> tutores = tutorService.listarTutor();
		return ResponseEntity.status(HttpStatus.OK).body(tutores);
    }	
	
	@PostMapping("/tutores")
	public ResponseEntity<Object> criarTutor(@RequestBody TutorContaAcessoDto tutorDto) {
		try {
			Tutor tutorCriado = tutorService.criarTutor(tutorDto.toModel());
			return new ResponseEntity<Object>(tutorCriado.toDto(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/tutores/{id}")
	public ResponseEntity<Object> atualizarTutor(@PathVariable(value = "id") Long id,
			@RequestBody TutorContaAcessoDto tutorDto){
		try {			
			Tutor tutoratualizado = tutorService.atualizarTutor(id, tutorDto.toModel());
			return ResponseEntity.status(HttpStatus.OK).body(tutoratualizado.toDto());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/tutores/{id}")
    public ResponseEntity<Object> deleteTutor(@PathVariable(value = "id") Long id){
        
        tutorService.deletarTutor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tutor deletado com sulcesso.");
    }

}