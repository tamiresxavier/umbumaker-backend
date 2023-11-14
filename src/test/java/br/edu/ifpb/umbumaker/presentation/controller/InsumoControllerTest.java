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

import br.edu.ifpb.umbumaker.model.Insumo;

@SpringBootTest
@AutoConfigureMockMvc
public class InsumoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Define alguns objetos de teste para usar nos testes

    @BeforeEach
    public void setUp() {
        // Inicialização de objetos de teste, se necessário
    }

    @Test
    public void testCriarInsumo() throws Exception {
        // Crie um objeto Insumo para enviar como JSON no corpo da solicitação
        Insumo insumo = new Insumo();
        insumo.setNome("Nome do Insumo");

        // Realize uma solicitação POST para criar um insumo
        mockMvc.perform(MockMvcRequestBuilders.post("/api/umbumaker/insumos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(insumo)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testListarInsumos() throws Exception {
        // Realize uma solicitação GET para listar insumos
        mockMvc.perform(MockMvcRequestBuilders.get("/api/umbumaker/insumos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}