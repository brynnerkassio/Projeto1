package br.com.fiap.am.druida.bo.teste;

import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.DespesaBO;

public class ListarDespesa {

	public static void main(String[] args) {
		
		Processo processo = new Processo();
		int nroProcesso = 3;								// Informe aqui o número do processo para para despesas relacionadas.
		processo.setNroProcesso(nroProcesso);

		Despesa despesa = new Despesa();
		despesa.setProcesso(processo);

		//
		
		Despesa id = new Despesa();
		DespesaBO ldBO = new DespesaBO();
		
		List<Despesa> lista = null;
		
		try {

			id = ldBO.recuperarDadosClienteListar(despesa);
			lista = ldBO.listarDespesa(despesa);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Processo processo2 = new Processo();
		processo2 = id.getProcesso();
		
		Cliente cliente = new Cliente();
		cliente = processo2.getCliente();
		
		System.out.println("Número do Processo: " + processo2.getNroProcesso());
		System.out.println("Cliente: " + cliente.getRazaoSocial());
		System.out.println("");

		for (Despesa desp : lista) {
			System.out.print("Data: ");
			System.out.print(desp.getDataDespesa());
			System.out.print(" | Nome: ");
			TipoDespesa td = new TipoDespesa();
			td = desp.getTipoDespesa();
			System.out.print(td.getTipoDespesa());
			System.out.print(" | Valor: ");
			System.out.print(desp.getValorDespesa());
			System.out.print(" | Código Lançamento: ");
			System.out.print(desp.getCodigoLancamento());
			System.out.print(" | número Processo: ");
			System.out.print(processo2.getNroProcesso());
			System.out.println("");
		}
	}
}
