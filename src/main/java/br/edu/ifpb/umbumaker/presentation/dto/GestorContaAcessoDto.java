package br.edu.ifpb.umbumaker.presentation.dto;

import br.edu.ifpb.umbumaker.model.ContaAcesso;
import br.edu.ifpb.umbumaker.model.Gestor;

public class GestorContaAcessoDto implements IDto<Gestor>{
	
	private String nome; 
	private String email; 
	private String senha;
	private String telefone;
	private String linkWhatsapp;
	private boolean ativo;
	private String qrcode;
	private String tipo;
	
	public GestorContaAcessoDto(Gestor gestor) {
		
		this.nome = gestor.getContaAcesso().getNome(); 
		this.email = gestor.getContaAcesso().getEmail(); 
		this.senha = gestor.getContaAcesso().getSenha();
		this.telefone = gestor.getContaAcesso().getTelefone();
		this.linkWhatsapp = gestor.getContaAcesso().getLinkWhatsapp();
		this.ativo = gestor.getContaAcesso().isAtivo();
		this.qrcode = gestor.getContaAcesso().getQrcode();
		this.tipo = gestor.getContaAcesso().getTipo();
		
	}
	
	public GestorContaAcessoDto() {
		
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
	
	

//	public Gestor getGestor() {
//		return gestor;
//	}
//
//	public void setGestor(Gestor gestor) {
//		this.gestor = gestor;
//	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public Gestor toModel() {
		// TODO Auto-generated method stub
		return new Gestor(new ContaAcesso(this.nome, this.email, this.senha, this.telefone,
				this.linkWhatsapp, this.ativo, this.qrcode, this.tipo));
	}

}