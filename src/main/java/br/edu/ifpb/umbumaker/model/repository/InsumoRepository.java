package br.edu.ifpb.umbumaker.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.umbumaker.model.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {

}