package br.edu.ifpb.umbumaker.model;

import br.edu.ifpb.umbumaker.presentation.dto.ContaAcessoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//ContaAcesso sem implementação do DTO
//ContaAcesso tem Repository, tem Service, más, não tem controler
//esta havendo um encapiçulamento danado de contaAcesso em Gestor :-D

@Entity
public class ContaAcesso implements IModel<ContaAcessoDto> {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContaAcesso;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String linkWhatsapp;
	private boolean ativo;
	private String qrcode;
	private String tipo;
	
	public ContaAcesso(String nome, String email, String senha, String telefone,
			String linkWhatsapp, boolean ativo, String qrcode, String tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.linkWhatsapp = linkWhatsapp;
		this.ativo = ativo;
		this.qrcode = qrcode;
		this.tipo = tipo;
	}
	
	public ContaAcesso() {
		
	}

	public Long getIdContaAcesso() {
		return idContaAcesso;
	}
	public void setIdContaAcesso(Long idContaAcesso) {
		this.idContaAcesso = idContaAcesso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLinkWhatsapp() {
		return linkWhatsapp;
	}
	public void setLinkWhatsapp(String linkWhatsapp) {
		this.linkWhatsapp = linkWhatsapp;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public ContaAcessoDto toDto() {
		// TODO Auto-generated method stub
		return new ContaAcessoDto(this.nome, this.email, this.senha, this.telefone,
				this.linkWhatsapp, this.ativo, this.qrcode,this.tipo);
	}
    
}