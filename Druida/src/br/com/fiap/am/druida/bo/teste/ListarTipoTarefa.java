package br.com.fiap.am.druida.bo.teste;

import java.util.List;

import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.bo.TipoTarefaBO;

public class ListarTipoTarefa {

	public static void main(String[] args) {
		
		List<TipoTarefa> lista = null;
		TipoTarefaBO ldBO = new TipoTarefaBO();
		
		try {

			lista = ldBO.recuperarTipoTarefa();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (TipoTarefa desp : lista) {
			System.out.print(desp.getCodigoTarefa());
			System.out.print(" ");
			System.out.println(desp.getTipoTarefa());
		}
	}
}
