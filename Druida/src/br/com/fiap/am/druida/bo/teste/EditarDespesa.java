package br.com.fiap.am.druida.bo.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.DespesaBO;

public class EditarDespesa {

	public static void main(String[] args) {
		
		Despesa despesa = new Despesa();
		
		int codigoLancamento = 43;							// Informe aqui o código de lançamento da despesa a ser editada.
		despesa.setCodigoLancamento(codigoLancamento);
		
		short codigoDespesa = 2;
		TipoDespesa tipoDespesa = new TipoDespesa();
		tipoDespesa.setCodigoDespesa(codigoDespesa);
		despesa.setTipoDespesa(tipoDespesa);

		String data = "05/10/2013";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		despesa.setDataDespesa(sqlDate);
		
		double valor = 10.2;
		despesa.setValorDespesa(valor);
		
		String obs = "Teste";
		despesa.setObservacao(obs);
		
		boolean desp = false;
		DespesaBO despesaBO = new DespesaBO();
		
		try {
			desp = despesaBO.editarDespesa(despesa);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		if(desp == true)
			msg = "Despesa Editada";
		else
			msg = "Despesa NÃO Editada!";
		
		System.out.println(msg);
	}
}
