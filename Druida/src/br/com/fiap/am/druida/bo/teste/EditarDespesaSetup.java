package br.com.fiap.am.druida.bo.teste;

import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.bo.DespesaBO;
import br.com.fiap.am.druida.bo.TipoDespesaBO;

public class EditarDespesaSetup {

	public static void main(String[] args) {
		
		Despesa despesa = new Despesa();
		int codigoLancamento = 38;							// Informe aqui o código de lançamento da despesa a ser recuperado.
		despesa.setCodigoLancamento(codigoLancamento);

		Despesa id = new Despesa();
		DespesaBO ldBO = new DespesaBO();
		
		List<TipoDespesa> lista = null;
		TipoDespesaBO despesaBO = new TipoDespesaBO();
		
		try {

			id = ldBO.editarDespesaSetup(despesa);
			lista = despesaBO.recuperarTipoDespesa();

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
		System.out.print("Código do Tipo Despesa: ");
		TipoDespesa tt = new TipoDespesa();
		tt = id.getTipoDespesa();
		System.out.print(tt.getCodigoDespesa());
		System.out.print(" | Data: ");
		System.out.print(id.getDataDespesa());
		System.out.print(" | Valor: ");
		System.out.print(id.getValorDespesa());
		System.out.print(" | Código Lançamento: ");
		System.out.print(id.getCodigoLancamento());
		System.out.print(" | Observações: ");
		System.out.print(id.getObservacao());
		System.out.println("");
		System.out.println("");
		
		for (TipoDespesa desp : lista) {
			System.out.print(desp.getCodigoDespesa());
			System.out.print(" ");
			System.out.println(desp.getTipoDespesa());
		}
	}
}
