package br.com.fiap.am.druida.bo.teste;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bo.HonorarioBO;

public class ExcluirHonorario {

	public static void main(String[] args) {
		
		Honorario honorario = new Honorario();
		
		int codigoLancamento = 21;							// Informe aqui o c�digo de lan�amento do honor�rio a ser exclu�do.
		honorario.setCodigoLancamento(codigoLancamento);
		
		boolean hon = false;
		HonorarioBO honorarioBO = new HonorarioBO();
		
		try {
			hon = honorarioBO.excluirHonorario(honorario);    		
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(hon == true)
			System.out.println("Honor�rio Exclu�do!");
	}
}
