package br.edu.ifpb.umbumaker.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.repository.TutorRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class TutorTest {

    @Autowired
    private TutorRepository tutorRepository;

    @Test
    public void testTutorIdGerado() {
        // Criar um Tutor fictício
    	Tutor tutor = new Tutor();

        // Salvar o Tutor no repositório
    	tutor = tutorRepository.save(tutor);

        // Verificar se o ID do Tutor foi gerado corretamente
        assertNotNull(tutor.getIdTutor());
    }

    @Test
    public void testTutor() {
        // Criar um Tutor fictício
    	Tutor tutor = new Tutor();

        // Salvar o Tutor no repositório
    	tutor = tutorRepository.save(tutor);

        // Recuperar o Tutor do repositório usando o ID
    	Tutor retrievedTutor = tutorRepository.findById(tutor.getIdTutor()).orElse(null);

        assertNotNull(retrievedTutor);
      
    }
    
}