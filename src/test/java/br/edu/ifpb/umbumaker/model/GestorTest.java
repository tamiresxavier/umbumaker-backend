package br.edu.ifpb.umbumaker.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.repository.GestorRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class GestorTest {

    @Autowired
    private GestorRepository gestorRepository;

    @Test
    public void testGestorIdGerado() {
        // Criar um Gestor fictício
    	Gestor gestor = new Gestor();

        // Salvar o Gestor no repositório
    	gestor = gestorRepository.save(gestor);

        // Verificar se o ID do Gestor foi gerado corretamente
        assertNotNull(gestor.getIdGestor());
    }

    @Test
    public void testGestor() {
        // Criar um Gestor fictício
    	Gestor gestor = new Gestor();

        // Salvar o Gestor no repositório
    	gestor = gestorRepository.save(gestor);

        // Recuperar o Gestor do repositório usando o ID
        Gestor retrievedGestor = gestorRepository.findById(gestor.getIdGestor()).orElse(null);

        assertNotNull(retrievedGestor);
      
    }
    
}