package br.com.fiap.am.druida.bo.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.bo.HonorarioBO;

public class EditarHonorario {

	public static void main(String[] args) {
		
		Honorario despesa = new Honorario();
		
		int codigoLancamento = 68;							// Informe aqui o código de lançamento do honorário a ser editado.
		despesa.setCodigoLancamento(codigoLancamento);
		
		short codigoHonorario = 2;
		TipoTarefa tipoTarefa = new TipoTarefa();
		tipoTarefa.setCodigoTarefa(codigoHonorario);
		despesa.setTipoTarefa(tipoTarefa);

		String data = "05/10/2013";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		despesa.setDataHonorario(sqlDate);
		
		double qntHora = 10;
		despesa.setQntHora(qntHora);
		
		String obs = "Teste";
		despesa.setObservacao(obs);
		
		boolean hon = false;
		HonorarioBO honorarioBO = new HonorarioBO();
		
		try {
			hon = honorarioBO.editarHonorario(despesa);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		if(hon == true)
			msg = "Honorário Editado no processo";
		else
			msg = "Honorário NÃO Editado!";
		
		System.out.println(msg);
	}
}