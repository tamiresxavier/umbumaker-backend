package br.edu.ifpb.umbumaker.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.umbumaker.model.LocalArmazenamento;

public interface LocalArmazenamentoRepository extends JpaRepository<LocalArmazenamento, Long> {

}