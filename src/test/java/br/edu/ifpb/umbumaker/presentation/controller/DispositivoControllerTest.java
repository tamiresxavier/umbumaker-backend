package br.edu.ifpb.umbumaker.presentation.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifpb.umbumaker.model.Dispositivo;

@SpringBootTest
@AutoConfigureMockMvc
public class DispositivoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // Inicialização de objetos de teste, se necessário
    }

    @Test
    public void testCriarDispositivo() throws Exception {
        // Crie um objeto Dispositivo para enviar como JSON no corpo da solicitação
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setModelo("Nome do Dispositivo");

        // Realize uma solicitação POST para criar um dispositivo
        mockMvc.perform(MockMvcRequestBuilders.post("/api/umbumaker/dispositivos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dispositivo)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testListarDispositivos() throws Exception {
        // Realize uma solicitação GET para listar dispositivos
        mockMvc.perform(MockMvcRequestBuilders.get("/api/umbumaker/dispositivos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
