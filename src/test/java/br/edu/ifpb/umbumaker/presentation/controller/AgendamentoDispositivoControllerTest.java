package br.edu.ifpb.umbumaker.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifpb.umbumaker.business.service.AgendamentoDispositivoService;
import br.edu.ifpb.umbumaker.model.AgendamentoDispositivo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AgendamentoDispositivoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // Inicialização de objetos de teste, se necessário
    }

    @MockBean
    private AgendamentoDispositivoService agendamentoDispositivoService;
    
    @Test
    public void testCriarAgendamentoDispositivo() throws Exception {
        // Crie um objeto AgendamentoDispositivo para enviar como JSON no corpo da solicitação
    	AgendamentoDispositivo agendamentoDispositivo = new AgendamentoDispositivo();
    	agendamentoDispositivo.setDescricao("Descrição do Agendamento do Dispositivo");

        // Realize uma solicitação POST para criar um dispositivo
        mockMvc.perform(MockMvcRequestBuilders.post("/api/umbumaker/agendamentodispositivo")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(agendamentoDispositivo)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testDeletarAgendamentoDispositivo() throws Exception {
        // Mocking service behavior
        long codigo = 1L;
        doNothing().when(agendamentoDispositivoService).deletarAgendamentoDispositivo(codigo);

        // Performing the actual HTTP request and validating the response
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/umbumaker/agendamentodispositivo/{codigo}", codigo))
                .andExpect(status().isNoContent());

        // Verifying that the service method was called
        verify(agendamentoDispositivoService, times(1)).deletarAgendamentoDispositivo(codigo);
    }

    @Test
    public void testListarAgendamentoDispositivos() throws Exception {
        // Realize uma solicitação GET para listar agendamentoDispositivos
        mockMvc.perform(MockMvcRequestBuilders.get("/api/umbumaker/agendamentodispositivo"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}