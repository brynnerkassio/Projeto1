package br.com.fiap.am.druida.bo.teste;

import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bo.HonorarioBO;

public class ExcluirHonorario {

	public static void main(String[] args) {
		
		Honorario honorario = new Honorario();
		
		int codigoLancamento = 21;							// Informe aqui o código de lançamento do honorário a ser excluído.
		honorario.setCodigoLancamento(codigoLancamento);
		
		boolean hon = false;
		HonorarioBO honorarioBO = new HonorarioBO();
		
		try {
			hon = honorarioBO.excluirHonorario(honorario);    		
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(hon == true)
			System.out.println("Honorário Excluído!");
	}
}
