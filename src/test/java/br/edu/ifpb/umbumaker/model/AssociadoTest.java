package br.edu.ifpb.umbumaker.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.repository.AssociadoRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class AssociadoTest {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Test
    public void testAssociadoIdGerado() {
        // Criar um Associado fictício
        Associado associado = new Associado();

        // Salvar o Associado no repositório
        associado = associadoRepository.save(associado);

        // Verificar se o ID do Associado foi gerado corretamente
        assertNotNull(associado.getId());
    }

    @Test
    public void testAssociado() {
        // Criar um Associado fictício
        Associado associado = new Associado();

        // Salvar o Associado no repositório
        associado = associadoRepository.save(associado);

        // Recuperar o Associado do repositório usando o ID
        Associado retrievedAssociado = associadoRepository.findById(associado.getId()).orElse(null);

        assertNotNull(retrievedAssociado);
      
    }
    
}