package br.edu.ifpb.umbumaker.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.repository.FilamentoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class FilamentoTest {

    @Autowired
    private FilamentoRepository filamentoRepository;

    @Test
    public void testFilamentoIdGerado() {
        // Criar um Filamento fictício
        Filamento filamento = new Filamento();

        // Salvar o Filamento no repositório
        filamento = filamentoRepository.save(filamento);

        // Verificar se o ID do Filamento foi gerado corretamente
        assertNotNull(filamento.getId());
    }

    @Test
    public void testFilamentoAtributos() {
        // Criar um Filamento fictício com atributos
        Filamento filamento = new Filamento();
        filamento.setNome("Filamento de Teste");

        // Salvar o Filamento no repositório
        filamento = filamentoRepository.save(filamento);

        // Recuperar o Filamento do repositório usando o ID
        Filamento retrievedFilamento = filamentoRepository.findById(filamento.getId()).orElse(null);

        assertNotNull(retrievedFilamento);
        assertEquals("Filamento de Teste", retrievedFilamento.getNome());

        // Adicione mais verificações conforme necessário
    }
    
}