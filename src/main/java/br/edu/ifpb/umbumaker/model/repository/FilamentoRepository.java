package br.edu.ifpb.umbumaker.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpb.umbumaker.model.Filamento;

public interface FilamentoRepository extends JpaRepository<Filamento, Long> {

	@Query("SELECT f FROM Filamento f WHERE f.dispositivo.codigo = :dispositivoId")
    List<Filamento> findByDispositivoCodigo(Long dispositivoId);
	
}