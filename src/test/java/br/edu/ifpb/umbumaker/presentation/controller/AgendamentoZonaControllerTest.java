package br.edu.ifpb.umbumaker.presentation.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifpb.umbumaker.business.service.AgendamentoZonaService;
import br.edu.ifpb.umbumaker.model.AgendamentoZona;

@SpringBootTest
@AutoConfigureMockMvc
public class AgendamentoZonaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // Inicialização de objetos de teste, se necessário
    }

    @MockBean
    private AgendamentoZonaService agendamentoZonaService;
    
    @Test
    public void testCriarAgendamentoZona() throws Exception {
        // Crie um objeto AgendamentoZona para enviar como JSON no corpo da solicitação
    	AgendamentoZona agendamentoZona = new AgendamentoZona();
    	agendamentoZona.setDescricao("Descrição do Agendamento do Zona");

        // Realize uma solicitação POST para criar um dispositivo
        mockMvc.perform(MockMvcRequestBuilders.post("/api/umbumaker/agendamentozona")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(agendamentoZona)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testDeletarAgendamentoZona() throws Exception {
        // Mocking service behavior
        long codigo = 1L;
        doNothing().when(agendamentoZonaService).deletarAgendamentoZona(codigo);

        // Performing the actual HTTP request and validating the response
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/umbumaker/agendamentozona/{codigo}", codigo))
                .andExpect(status().isNoContent());

        // Verifying that the service method was called
        verify(agendamentoZonaService, times(1)).deletarAgendamentoZona(codigo);
    }

    @Test
    public void testListarAgendamentoZonas() throws Exception {
        // Realize uma solicitação GET para listar agendamentosZonas
        mockMvc.perform(MockMvcRequestBuilders.get("/api/umbumaker/agendamentozona"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}