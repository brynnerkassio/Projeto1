package br.com.fiap.am.druida.view;

import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.TimeZone;



import javax.swing.JOptionPane;

import br.com.fiap.am.druida.advocacia.AdvocaciaException;
import br.com.fiap.am.druida.bo.HonorarioBO;
import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoTarefa;

public class LancarHonorario {

	public void lancarHonorario() throws HeadlessException, AdvocaciaException {

		Honorario honorario = new Honorario();
		
		Processo processo = new Processo();
		processo.setNroProcesso(Integer.parseInt(JOptionPane.showInputDialog("Informe o número do Processo a incluir o Lançamento de Honorário")));
		honorario.setProcesso(processo);
		
		TipoTarefa tipoTarefa = new TipoTarefa();
		tipoTarefa.setCodigoTarefa(Byte.parseByte(JOptionPane.showInputDialog("Informe o Tipo de Honorário")));
		honorario.setTipoTarefa(tipoTarefa);
				
		String data = JOptionPane.showInputDialog("Informe a Data do Honorário");

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		// format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		java.util.Date date = null;
		try {
			date = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		honorario.setDataHonorario(sqlDate);

		/*
		 * SimpleDateFormat sdf = null; sdf = new
		 * SimpleDateFormat("dd/MM/yyyy"); Date dt = null; try { dt =
		 * sdf.parse(data); } catch (ParseException e) { e.printStackTrace(); }
		 * Calendar cal = Calendar.getInstance(); cal.setTime(dt);
		 * despesa.setDataDespesa(cal);
		 */

		honorario.setQntHora(Double.parseDouble(JOptionPane.showInputDialog("Informe a Quantidade de Horas trabalhadas")));
		honorario.setObservacao(JOptionPane.showInputDialog("Informe Observações se houve"));

		HonorarioBO honorarioBO = new HonorarioBO();

		if (honorarioBO.cadastrarHonorario(honorario) == true)
			JOptionPane.showMessageDialog(null, "Honorário Lançado!");
		else
			JOptionPane.showMessageDialog(null, "Honorário NÃO Lançado!");
	}

}
