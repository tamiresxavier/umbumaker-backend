package br.edu.ifpb.umbumaker.presentation.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.AgendamentoDispositivo;
import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.enums.StatusObjeto;

@SpringBootTest
@Transactional
public class AgendamentoDispositivoDtoTest {

    @Test
    public void testToModel() {
        // Create sample input
        LocalDate dataSolicitacao = LocalDate.now();
        String email = "example@email.com";
        LocalDate dataAgendamento = LocalDate.now().plusDays(7);
        String descricao = "Sample Description";
        String politicaDeAceite = "Sample Policy";
        StatusObjeto status = StatusObjeto.INICIADO;
 
        // Create an instance of the DTO
        AgendamentoDispositivoDto agendamentoDto = new AgendamentoDispositivoDto();

        // Test the conversion to the model
        AgendamentoDispositivo agendamentoModel = agendamentoDto.toModel();

        // Validate the output
        assertEquals(dataSolicitacao, agendamentoModel.getDataSolicitacao());
        assertEquals(email, agendamentoModel.getEmail());
        // Check other properties similarly
    }
}
