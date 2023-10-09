package br.edu.ifpb.umbumaker.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.enums.TipoDispositivo;
import br.edu.ifpb.umbumaker.model.enums.TipoFilamento;
import br.edu.ifpb.umbumaker.model.repository.DispositivoRepository;

@SpringBootTest
@Transactional
public class DispositivoServiceTest {
	
	@Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DispositivoService dispositivoService;
    
	@Test
	public void testAtualizarDispositivo() {
	    // Create an Dispositivo object and save it using the repository
		Dispositivo dispositivo = new Dispositivo("Modelo 2", LocalDate.now(), "TempMax", 1, 2, 3, TipoDispositivo.CANETA3D, Arrays.asList(TipoFilamento.ABS));
		Dispositivo savedDispositivo = dispositivoRepository.save(dispositivo);

	    // Update some properties of the dispositivo
	    savedDispositivo.setModelo("Updated Dispositivo");

	    // Call the atualizarDispositivo method
	    Dispositivo updatedDispositivo = dispositivoService.atualizarDispositivo(savedDispositivo.getCodigo(), savedDispositivo);

	    // Assert that the updatedInsumo has the expected values
	    assertEquals("Updated Dispositivo", updatedDispositivo.getModelo());
	    // Add more assertions as needed
	}
    
}