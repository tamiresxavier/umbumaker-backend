package br.edu.ifpb.umbumaker.model;

import br.edu.ifpb.umbumaker.presentation.dto.AssociadoContaAcessoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Associado implements IModel<AssociadoContaAcessoDto>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idContaAcesso")
	private ContaAcesso contaAcesso;

	public Associado(ContaAcesso contaAcesso) {
		super();
		this.contaAcesso = contaAcesso;
	}

	public Associado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContaAcesso getContaAcesso() {
		return contaAcesso;
	}

	public void setContaAcesso(ContaAcesso contaAcesso) {
		this.contaAcesso = contaAcesso;
	}

	@Override
	public AssociadoContaAcessoDto toDto() {
		// TODO Auto-generated method stub
		return new AssociadoContaAcessoDto(this);
	}
	
	
}
