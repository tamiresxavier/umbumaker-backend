package br.edu.ifpb.umbumaker.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.umbumaker.model.Insumo;
import br.edu.ifpb.umbumaker.model.enums.StatusEstoque;
import br.edu.ifpb.umbumaker.model.enums.UnidadeMedida;
import br.edu.ifpb.umbumaker.model.repository.InsumoRepository;


@SpringBootTest
@Transactional
public class InsumoServiceTest {

	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private InsumoRepository insumoRepository;

	@Test
	public void testCriarInsumo() {
		// Create an Insumo object
		Insumo insumo = new Insumo("Test Insumo", 100, 10, 30, UnidadeMedida.KILO, StatusEstoque.REGULAR);

		// Call the criarInsumo method
		Insumo createdInsumo = insumoService.criarInsumo(insumo);

		// Assert that the createdInsumo is not null and has the expected values
		assertNotNull(createdInsumo);
		assertEquals("Test Insumo", createdInsumo.getNome());
		// Add more assertions as needed
	}

	@Test
	public void testAtualizarInsumo() {
	    // Create an Insumo object and save it using the repository
	    Insumo insumo = new Insumo("Test Insumo", 100, 10, 30, UnidadeMedida.KILO, StatusEstoque.ABAIXO_MINIMO);
	    Insumo savedInsumo = insumoRepository.save(insumo);

	    // Update some properties of the insumo
	    savedInsumo.setNome("Updated Insumo");

	    // Call the atualizarInsumo method
	    Insumo updatedInsumo = insumoService.atualizarInsumo(savedInsumo.getCodigo(), savedInsumo);

	    // Assert that the updatedInsumo has the expected values
	    assertEquals("Updated Insumo", updatedInsumo.getNome());
	    // Add more assertions as needed
	}

	@Test
	public void testDeletarInsumo() {
	    // Create an Insumo object and save it using the repository
	    Insumo insumo = new Insumo("Test Insumo", 100, 10, 30, UnidadeMedida.KILO, StatusEstoque.ABAIXO_MINIMO);
	    Insumo savedInsumo = insumoRepository.save(insumo);

	    // Call the deletarInsumo method to delete the savedInsumo
	    insumoService.deletarInsumo(savedInsumo.getCodigo());

	    // Check if the insumo has been deleted
	    assertFalse(insumoRepository.existsById(savedInsumo.getCodigo()));
	}

	@Test
	public void testListarInsumos() {
	    // Create and save multiple Insumo objects using the repository
	    Insumo insumo1 = new Insumo("Insumo 1", 50, 5, 20, UnidadeMedida.LITRO, StatusEstoque.ABAIXO_MINIMO);
	    Insumo insumo2 = new Insumo("Insumo 2", 75, 10, 15, UnidadeMedida.METRO, StatusEstoque.REGULAR);
	    insumoRepository.saveAll(Arrays.asList(insumo1, insumo2));

	    // Call the listarInsumos method to get a list of Insumo objects
	    List<Insumo> insumos = insumoService.listarInsumos();

	    // Assert that the list is not empty and contains the expected number of elements
	    assertFalse(insumos.isEmpty());
	    assertEquals(2, insumos.size());
	    // Add more assertions as needed
	}

}