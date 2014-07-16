package br.com.fiap.am.druida.view;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import br.com.fiap.am.druida.advocacia.AdvocaciaException;
import br.com.fiap.am.druida.bo.HonorarioBO;
import br.com.fiap.am.druida.bean.Honorario;

public class ExcluirHonorario {

	public void excluirHonorario() throws HeadlessException, AdvocaciaException {

		Honorario honorario = new Honorario();

		honorario.setCodigoLancamento(Integer.parseInt(JOptionPane.showInputDialog("Informe o número do Lançamento de Honorário a excluir")));

		HonorarioBO honorarioBO = new HonorarioBO();

		if (honorarioBO.excluirHonorario(honorario) == true)
			JOptionPane.showMessageDialog(null, "Honorário Excluído!");
		else
			JOptionPane.showMessageDialog(null, "Honorário NÃO Excluído!");

	}

}
