package br.edu.ifpb.umbumaker.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.ZonaTrabalho;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class ZonaTrabalhoServiceTest {

    @Autowired
    private ZonaTrabalhoService zonaTrabalhoService;

    @Test
    public void testCriarZonaTrabalho() {
        ZonaTrabalho zonaTrabalho = new ZonaTrabalho("Sala A", LocalDate.now(), LocalDate.now(), false, 5, new Dispositivo());
        ZonaTrabalho zonaCriada = zonaTrabalhoService.criarZonaTrabalho(zonaTrabalho);
        assertNotNull(zonaCriada.getCodigo());
        assertEquals("Sala A", zonaCriada.getNome());
        // Adicione mais verificações conforme necessário.
    }

}