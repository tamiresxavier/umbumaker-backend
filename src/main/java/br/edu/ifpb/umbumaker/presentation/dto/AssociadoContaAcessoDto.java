package br.edu.ifpb.umbumaker.presentation.dto;

import br.edu.ifpb.umbumaker.model.Associado;
import br.edu.ifpb.umbumaker.model.ContaAcesso;

public class AssociadoContaAcessoDto implements IDto<Associado>{
	
	private String nome; 
	private String email; 
	private String senha;
	private String telefone;
	private String linkWhatsapp;
	private boolean ativo;
	private String qrcode;
	private String tipo;
	
	public AssociadoContaAcessoDto(Associado associado) {
		
		this.nome = associado.getContaAcesso().getNome(); 
		this.email = associado.getContaAcesso().getEmail(); 
		this.senha = associado.getContaAcesso().getSenha();
		this.telefone = associado.getContaAcesso().getTelefone();
		this.linkWhatsapp = associado.getContaAcesso().getLinkWhatsapp();
		this.ativo = associado.getContaAcesso().isAtivo();
		this.qrcode = associado.getContaAcesso().getQrcode();
		this.tipo = associado.getContaAcesso().getTipo();
		
	}
	
	public AssociadoContaAcessoDto() {
		
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
	public Associado toModel() {
		// TODO Auto-generated method stub
		return new Associado(new ContaAcesso(this.nome, this.email, this.senha, this.telefone,
				this.linkWhatsapp, this.ativo, this.qrcode, this.tipo));
	}

}