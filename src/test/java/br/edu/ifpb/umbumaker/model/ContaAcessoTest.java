package br.edu.ifpb.umbumaker.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifpb.umbumaker.model.repository.ContaAcessoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ContaAcessoTest {

    @Autowired
    private ContaAcessoRepository contaAcessoRepository;

    @Test
    public void testSaveAndRetrieveContaAcesso() {
        ContaAcesso contaAcesso = new ContaAcesso("Tamires", "tx@gmail.com", "senha", "1234567890",
                "https://whatsapp.com", true, "qrcode", "tipo");

        contaAcesso = contaAcessoRepository.save(contaAcesso);

        assertNotNull(contaAcesso.getIdContaAcesso());

        ContaAcesso retrievedContaAcesso = contaAcessoRepository.findById(contaAcesso.getIdContaAcesso()).orElse(null);

        assertNotNull(retrievedContaAcesso);
        assertEquals("Tamires", retrievedContaAcesso.getNome());
        assertEquals("tx@gmail.com", retrievedContaAcesso.getEmail());
        assertEquals("senha", retrievedContaAcesso.getSenha());

    }
    
}