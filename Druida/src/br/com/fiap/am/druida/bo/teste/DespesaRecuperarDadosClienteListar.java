package br.com.fiap.am.druida.bo.teste;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Despesa;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bo.DespesaBO;

public class DespesaRecuperarDadosClienteListar {

	public static void main(String[] args) {
		
		Processo processo = new Processo();
		processo.setNroProcesso(6);							// Informe aqui o n�mero do processo para recuperar dados b�sicos usados em formul�rios.
		
		Despesa despesa = new Despesa();
		despesa.setProcesso(processo);
		
		DespesaBO despesaBO = new DespesaBO();
		
		//
		
		Despesa despesa2 = new Despesa();
		despesa2 = despesaBO.recuperarDadosClienteLancar(despesa);
		
		Processo processo2 = new Processo();
		processo2 = despesa2.getProcesso();
		
		Cliente cliente = new Cliente();
		cliente = processo2.getCliente();
		
		System.out.println("N�mero do Processo: " + processo2.getNroProcesso());
		System.out.println("Cliente: " + cliente.getRazaoSocial());
	}
}
