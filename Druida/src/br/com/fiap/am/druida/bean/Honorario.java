package br.com.fiap.am.druida.bean;

import java.sql.Date;

public class Honorario {

	private int codigoLancamento;
	private Processo processo;
	private TipoTarefa tipoTarefa;
	private Date dataHonorario;
	private String dataHonorarioReturn;
	private double qntHora;
	private String observacao;

	public Honorario() {
	}

	public int getCodigoLancamento() {
		return codigoLancamento;
	}

	public void setCodigoLancamento(int codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public Date getDataHonorario() {
		return dataHonorario;
	}

	public void setDataHonorario(Date dataHonorario) {
		this.dataHonorario = dataHonorario;
	}

	public double getQntHora() {
		return qntHora;
	}

	public void setQntHora(double qntHora) {
		this.qntHora = qntHora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDataHonorarioReturn() {
		return dataHonorarioReturn;
	}

	public void setDataHonorarioReturn(String dataHonorarioReturn) {
		this.dataHonorarioReturn = dataHonorarioReturn;
	}

}
