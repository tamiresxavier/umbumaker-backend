package br.edu.ifpb.umbumaker.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.repository.DispositivoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class DispositivoTest {

    @Autowired
    private DispositivoRepository dispositivo3DRepository;

    @Test
    public void testDispositivoIdGerado() {
        // Criar um Dispositivo fictício
        Dispositivo dispositivo = new Dispositivo();

        // Salvar o Dispositivo no repositório
        dispositivo = dispositivo3DRepository.save(dispositivo);

        // Verificar se o ID do Dispositivo foi gerado corretamente
        assertNotNull(dispositivo.getCodigo());
    }

    @Test
    public void testDispositivoAtributos() {
        // Criar um Dispositivo fictício com atributos
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setModelo("Modelo de Teste");
        dispositivo.setTemperaturaMaxima("Temperatura Máxima Teste");

        // Salvar o Dispositivo no repositório
        dispositivo = dispositivo3DRepository.save(dispositivo);

        // Recuperar o Dispositivo do repositório usando o ID
        Dispositivo retrievedDispositivo = dispositivo3DRepository.findById(dispositivo.getCodigo()).orElse(null);

        assertNotNull(retrievedDispositivo);
        assertEquals("Modelo de Teste", retrievedDispositivo.getModelo());
        assertEquals("Temperatura Máxima Teste", retrievedDispositivo.getTemperaturaMaxima());

    }
    
}