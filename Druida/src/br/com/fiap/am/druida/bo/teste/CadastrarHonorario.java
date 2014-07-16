package br.com.fiap.am.druida.bo.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.bo.HonorarioBO;

public class CadastrarHonorario {

	public static void main(String[] args) {
		
		Honorario honorario = new Honorario();
		
		int nroProcesso = 1;												// N�mero do Processo
		Processo processo = new Processo();
		processo.setNroProcesso(nroProcesso);
		honorario.setProcesso(processo);
		
		short codigoHonorario = 2;											// C�digo do Honor�rio
		TipoTarefa tipoTarefa = new TipoTarefa();
		tipoTarefa.setCodigoTarefa(codigoHonorario);
		honorario.setTipoTarefa(tipoTarefa);

		String data = "30/10/2013";											// Data
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		honorario.setDataHonorario(sqlDate);
		
		double qntHora = 10;												// Quantidade de Horas
		honorario.setQntHora(qntHora);
		
		String obs = "Teste";												// Observa��o
		honorario.setObservacao(obs);

		boolean hn = false;
		HonorarioBO honorarioBO = new HonorarioBO();
		
		try {
			hn = honorarioBO.cadastrarHonorario(honorario);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(hn == true)
			System.out.println("Hon�rario Inserido no processo n� " + processo.getNroProcesso());
		else
			System.out.println("Honor�rio N�O Inserido!");
	}
}
