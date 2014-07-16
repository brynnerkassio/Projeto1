package br.com.fiap.am.druida.bean;

import java.sql.Date;

public class Despesa {

	private int codigoLancamento;
	private Processo processo;
	private TipoDespesa tipoDespesa;
	private Date dataDespesa;
	private String dataDespesaReturn;
	private double valorDespesa;
	private String observacao;

	public Despesa() {
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

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDataDespesaReturn() {
		return dataDespesaReturn;
	}

	public void setDataDespesaReturn(String dataDespesaReturn) {
		this.dataDespesaReturn = dataDespesaReturn;
	}

}
