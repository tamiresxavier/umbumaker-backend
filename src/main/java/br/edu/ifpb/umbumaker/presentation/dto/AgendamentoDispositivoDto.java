package br.edu.ifpb.umbumaker.presentation.dto;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.umbumaker.model.AgendamentoDispositivo;
import br.edu.ifpb.umbumaker.model.Dispositivo;
import br.edu.ifpb.umbumaker.model.enums.StatusObjeto;

public class AgendamentoDispositivoDto implements IDto<AgendamentoDispositivo> {
	private LocalDate dataSolicitacao;
	private String email;
	private LocalDate dataAgendamento;
	private String descricao;
	private String politicaDeAceite;
	private StatusObjeto status;
	private List<Dispositivo> dispositivos;
	
	public AgendamentoDispositivoDto(LocalDate dataSolicitacao, String email, LocalDate dataAgendamento,
			String descricao, String politicaDeAceite, StatusObjeto status, List<Dispositivo> dispositivos) {
		this.dataSolicitacao = dataSolicitacao;
		this.email = email;
		this.dataAgendamento = dataAgendamento;
		this.descricao = descricao;
		this.politicaDeAceite = politicaDeAceite;
		this.status = status;
		this.dispositivos = dispositivos;
	}
	
	public AgendamentoDispositivoDto() {
	
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPoliticaDeAceite() {
		return politicaDeAceite;
	}

	public void setPoliticaDeAceite(String politicaDeAceite) {
		this.politicaDeAceite = politicaDeAceite;
	}

	public StatusObjeto getStatus() {
		return status;
	}

	public void setStatus(StatusObjeto status) {
		this.status = status;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	@Override
	public AgendamentoDispositivo toModel() {
		return new AgendamentoDispositivo (this.dataSolicitacao, this.email, this.dataAgendamento, this.descricao,
				this.politicaDeAceite, this.status, this.dispositivos);
	}

}