package br.edu.ifpb.umbumaker.presentation.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.enums.TipoDispositivo;
import br.edu.ifpb.umbumaker.model.enums.TipoFilamento;

@SpringBootTest
@Transactional
public class DispositivoDtoTest {

    @Test
    public void testToModel() {
        // Create sample input
        String modelo = "Sample Model";
        LocalDate ultimaManutencao = LocalDate.now().minusMonths(1);
        String temperaturaMaxima = "70°C";
        Integer eixoX = 10;
        Integer eixoY = 20;
        Integer eixoZ = 30;
        TipoDispositivo tipo = TipoDispositivo.CANETA3D;
        List<TipoFilamento> tipoFilamentoSuportado = Arrays.asList(TipoFilamento.PLA, TipoFilamento.ABS);

        // Create an instance of the DTO
        DispositivoDto dispositivoDto = new DispositivoDto(modelo, ultimaManutencao, temperaturaMaxima, eixoX, eixoY, eixoZ, tipo, tipoFilamentoSuportado);

        // Test the conversion to the model
        Dispositivo dispositivoModel = dispositivoDto.toModel();

        // Validate the output
        assertEquals(modelo, dispositivoModel.getModelo());
        assertEquals(ultimaManutencao, dispositivoModel.getUltimaManutencao());
        // Check other properties similarly
    }
    
}