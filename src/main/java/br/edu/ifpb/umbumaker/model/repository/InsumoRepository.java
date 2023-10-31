package br.edu.ifpb.umbumaker.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.umbumaker.model.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
	
	 Optional<Insumo> findById(Long codigo);

}