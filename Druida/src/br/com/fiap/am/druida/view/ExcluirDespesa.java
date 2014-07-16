package br.com.fiap.am.druida.view;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import br.com.fiap.am.druida.advocacia.AdvocaciaException;
import br.com.fiap.am.druida.bo.DespesaBO;
import br.com.fiap.am.druida.bean.Despesa;

public class ExcluirDespesa {

	public void excluirDespesa() throws HeadlessException, AdvocaciaException {

		Despesa despesa = new Despesa();

		despesa.setCodigoLancamento(Integer.parseInt(JOptionPane
				.showInputDialog("Informe o número do Lançamento de Despesa a excluir")));

		DespesaBO despesaBO = new DespesaBO();

		if (despesaBO.excluirDespesa(despesa) == true)
			JOptionPane.showMessageDialog(null, "Despesa Excluída!");
		else
			JOptionPane.showMessageDialog(null, "Despesa NÃO Excluída!");
	}

}
