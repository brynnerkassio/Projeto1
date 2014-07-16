package br.com.fiap.am.druida.bo.teste;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Honorario;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.bo.HonorarioBO;

public class HonorarioRecuperarDadosClienteListar {

	public static void main(String[] args) {
		
		Processo processo = new Processo();
		processo.setNroProcesso(6);							// Informe aqui o número do processo para recuperar dados básicos usados em formulários.
		
		Honorario honorario = new Honorario();
		honorario.setProcesso(processo);
		
		HonorarioBO honorarioBO = new HonorarioBO();
		
		//
		
		Honorario honorario2 = new Honorario();
		honorario2 = honorarioBO.recuperarDadosClienteLancar(honorario);
		
		Processo processo2 = new Processo();
		processo2 = honorario2.getProcesso();
		
		Cliente cliente = new Cliente();
		cliente = processo2.getCliente();
		
		System.out.println("Número do Processo: " + processo2.getNroProcesso());
		System.out.println("Cliente: " + cliente.getRazaoSocial());
	}
}