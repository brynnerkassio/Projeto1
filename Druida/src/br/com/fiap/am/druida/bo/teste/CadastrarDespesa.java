package br.com.fiap.am.druida.bo.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.DespesaBO;

public class CadastrarDespesa {

	public static void main(String[] args) {
		
		Despesa despesa = new Despesa();
		
		int nroProcesso = 1;												// Número do Processo
		Processo processo = new Processo();
		processo.setNroProcesso(nroProcesso);
		despesa.setProcesso(processo);
		
		short codigoDespesa = 2;											// Código da Despesa
		TipoDespesa tipoDespesa = new TipoDespesa();
		tipoDespesa.setCodigoDespesa(codigoDespesa);
		despesa.setTipoDespesa(tipoDespesa);

		String data = "30/10/2013";											// Data
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		despesa.setDataDespesa(sqlDate);
		
		double valor = 10.5;												// Valor
		despesa.setValorDespesa(valor);
		
		String obs = "Teste";												// Observação
		despesa.setObservacao(obs);

		boolean desp = false;
		DespesaBO despesaBO = new DespesaBO();
		
		try {
			desp = despesaBO.cadastrarDespesa(despesa);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(desp == true)
			System.out.println("Despesa Inserida no processo nº " + processo.getNroProcesso());
		else
			System.out.println("Despesa NÃO Inserida!");
	}
}
