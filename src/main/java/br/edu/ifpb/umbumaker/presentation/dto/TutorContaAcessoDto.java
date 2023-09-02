package br.edu.ifpb.umbumaker.presentation.dto;

import br.edu.ifpb.umbumaker.model.ContaAcesso;
import br.edu.ifpb.umbumaker.model.Tutor;

public class TutorContaAcessoDto implements IDto<Tutor>{
	
	private String nome; 
	private String email; 
	private String senha;
	private String telefone;
	private String linkWhatsapp;
	private boolean ativo;
	private String qrcode;
	private String tipo;
	
	public TutorContaAcessoDto(Tutor tutor) {
		
		this.nome = tutor.getContaAcesso().getNome(); 
		this.email = tutor.getContaAcesso().getEmail(); 
		this.senha = tutor.getContaAcesso().getSenha();
		this.telefone = tutor.getContaAcesso().getTelefone();
		this.linkWhatsapp = tutor.getContaAcesso().getLinkWhatsapp();
		this.ativo = tutor.getContaAcesso().isAtivo();
		this.qrcode = tutor.getContaAcesso().getQrcode();
		this.tipo = tutor.getContaAcesso().getTipo();
		
	}
	
	public TutorContaAcessoDto() {
		
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
	public Tutor toModel() {
		// TODO Auto-generated method stub
		return new Tutor(new ContaAcesso(this.nome, this.email, this.senha, this.telefone,
				this.linkWhatsapp, this.ativo, this.qrcode, this.tipo));
	}

}