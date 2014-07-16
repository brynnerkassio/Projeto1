package br.com.fiap.am.druida.bo.teste;

import java.util.List;

import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.TipoDespesaBO;

public class ListarTipoDespesa {

	public static void main(String[] args) {
		
		List<TipoDespesa> lista = null;
		TipoDespesaBO ldBO = new TipoDespesaBO();
		
		try {

			lista = ldBO.recuperarTipoDespesa();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (TipoDespesa desp : lista) {
			System.out.print(desp.getCodigoDespesa());
			System.out.print(" ");
			System.out.println(desp.getTipoDespesa());
		}
	}
}
