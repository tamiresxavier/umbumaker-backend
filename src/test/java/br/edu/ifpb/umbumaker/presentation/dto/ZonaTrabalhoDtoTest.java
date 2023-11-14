package br.edu.ifpb.umbumaker.presentation.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.ZonaTrabalho;

@SpringBootTest
@Transactional
public class ZonaTrabalhoDtoTest {

    @Test
    public void testToModel() {
        // Create sample input
        String nome = "Work Zone";
        LocalDate dataAgendada = LocalDate.now();
        LocalDate tempoReservado = LocalDate.now().plusDays(2);
        boolean reservada = true;
        Integer qtdPessoas = 5;
        Dispositivo equipamentos = new Dispositivo(); // Mock or create necessary equipment data

        // Create an instance of the DTO
        ZonaTrabalhoDto zonaDto = new ZonaTrabalhoDto(nome, dataAgendada, tempoReservado, reservada, qtdPessoas, equipamentos);

        // Test the conversion to the model
        ZonaTrabalho zonaModel = zonaDto.toModel();

        // Validate the output
        assertEquals(nome, zonaModel.getNome());
        assertEquals(dataAgendada, zonaModel.getDataAgendada());
        // Check other properties similarly
    }
    
}