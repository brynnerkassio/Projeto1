package br.com.fiap.am.druida.bo.teste;

import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bo.DespesaBO;

public class ExcluirDespesa {

	public static void main(String[] args) {
		
		Despesa despesa = new Despesa();
		
		int codigoLancamento = 42;							// Informe aqui o c�digo de lan�amento da despesa a ser exclu�da.
		despesa.setCodigoLancamento(codigoLancamento);
		
		boolean desp = false;
		DespesaBO despesaBO = new DespesaBO();
		
		try {
			desp = despesaBO.excluirDespesa(despesa);    		
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(desp == true)
			System.out.println("Despesa Exclu�da!");
	}
}
