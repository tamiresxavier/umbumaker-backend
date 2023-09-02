package br.edu.ifpb.umbumaker.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.umbumaker.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
	
}