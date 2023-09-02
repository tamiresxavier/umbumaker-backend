package br.edu.ifpb.umbumaker.presentation.dto;

import br.edu.ifpb.umbumaker.model.ContaAcesso;

public class ContaAcessoDto implements IDto<ContaAcesso>{
	
	private String nome; 
	private String email; 
	private String senha;
	private String telefone;
	private String linkWhatsapp;
	private boolean ativo;
	private String qrcode;
	private String tipo;
	
	public ContaAcessoDto(String nome, String email, String senha, String telefone,
			String linkWhatsapp, boolean ativo, String qrcode, String tipo) {
		
		this.nome = nome; 
		this.email = email; 
		this.senha = senha;
		this.telefone = telefone;
		this.linkWhatsapp = linkWhatsapp;
		this.ativo = ativo;
		this.qrcode = qrcode;
		this.tipo = tipo;
		
	}
	
	public ContaAcessoDto() {
		
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
	public ContaAcesso toModel() {
		// TODO Auto-generated method stub
		return new ContaAcesso(this.nome, this.email, this.senha, this.telefone,
				this.linkWhatsapp, this.ativo, this.qrcode, this.tipo);
	}
	
}