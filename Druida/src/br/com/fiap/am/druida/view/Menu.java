package br.com.fiap.am.druida.view;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {

		byte codigo = 0;
		String menu = "LCA Druida Advocacia - Menu Interativo\n\n1 - Lançar Honorário\n2 - Excluir Honorário\n3 - Excluir Despesa\n4 - Sair";
		String msg = null;

		try {

			LancarHonorario lh = new LancarHonorario();
			ExcluirHonorario eh = new ExcluirHonorario();
			ExcluirDespesa ed = new ExcluirDespesa();

			do {

				codigo = Byte.parseByte(JOptionPane.showInputDialog(menu));

				switch (codigo) {
				case 1:
					lh.lancarHonorario();
					break;

				case 2:
					eh.excluirHonorario();
					break;

				case 3:
					ed.excluirDespesa();
					break;

				case 4:
					msg = "Programa Encerrado!";
					JOptionPane.showMessageDialog(null, msg);
					break;

				default:
					msg = "Opção Inválida!";
					JOptionPane.showMessageDialog(null, msg);
					break;
				}

			} while (codigo != 4);

		} catch (NumberFormatException e) {

			msg = "São aceitos somente números!";
			JOptionPane.showMessageDialog(null, msg);
			System.err.println(msg);
			e.printStackTrace();

		} catch (Exception e) {

			msg = "Erro! Entre em contato com o Desenvolvedor!";
			JOptionPane.showMessageDialog(null, msg);
			System.err.println(msg);
			e.printStackTrace();

		}
	}

}
