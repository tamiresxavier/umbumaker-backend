package br.edu.ifpb.umbumaker.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.umbumaker.model.Gestor;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Long> {
	
	//Optional<Gestor> findByNome(String nome);
	
}