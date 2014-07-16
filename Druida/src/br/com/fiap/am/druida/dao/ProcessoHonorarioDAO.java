package br.com.fiap.am.druida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.druida.bean.Cliente;
import br.com.fiap.am.druida.bean.Processo;
import br.com.fiap.am.druida.jdbc.DBManager;

public class ProcessoHonorarioDAO {

	public List<Processo> recuperarProcPorNro(Processo objP) {
		
		List<Processo> processo = new ArrayList<Processo>();

		Connection conn = DBManager.getInstancia().getConexao();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT P.NR_PROCESSO, P.DS_PROCESSO, CL.DS_RAZAO_SOCIAL FROM T_AM_DRD_PROCESSO P INNER JOIN T_AM_DRD_CLIENTE Cl ON (P.CD_CLIENTE = Cl.CD_CLIENTE) WHERE P.NR_PROCESSO = ? AND P.DT_FECHAMENTO IS NULL");
			ps.setInt(1, objP.getNroProcesso());

			rs = ps.executeQuery();

			while (rs.next()) {

				Processo p2 = new Processo();
				Cliente cl = new Cliente();

				p2.setNroProcesso(rs.getInt("NR_PROCESSO"));
				p2.setDescricao(rs.getString("DS_PROCESSO"));
				cl.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
				p2.setCliente(cl);

				processo.add(p2);
			}

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return processo;
	}
	
	public List<Processo> recuperarProcPorCliente(Cliente objC) {

		String razaoSocial = "%";
		razaoSocial += objC.getRazaoSocial();
		razaoSocial += "%";
		
		List<Processo> processo = new ArrayList<Processo>();

		Connection conn = DBManager.getInstancia().getConexao();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT P.NR_PROCESSO, P.DS_PROCESSO, CL.DS_RAZAO_SOCIAL FROM T_AM_DRD_PROCESSO P INNER JOIN T_AM_DRD_CLIENTE Cl ON (P.CD_CLIENTE = Cl.CD_CLIENTE) WHERE UPPER(CL.DS_RAZAO_SOCIAL) LIKE ? AND P.DT_FECHAMENTO IS NULL");
			ps.setString(1, razaoSocial.toUpperCase());

			rs = ps.executeQuery();

			while (rs.next()) {

				Processo p2 = new Processo();
				Cliente cl = new Cliente();

				p2.setNroProcesso(rs.getInt("NR_PROCESSO"));
				p2.setDescricao(rs.getString("DS_PROCESSO"));
				cl.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
				p2.setCliente(cl);

				processo.add(p2);
			}

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return processo;
	}
	
	public List<Processo> recuperarProcPorPeriodo(Processo objD) {

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
		String dataInicial = formatador.format(objD.getDataAbertura().getTime());
		String dataFinal = formatador.format(objD.getDataFechamento().getTime());
		
		List<Processo> processo = new ArrayList<Processo>();

		Connection conn = DBManager.getInstancia().getConexao();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT P.NR_PROCESSO, P.DS_PROCESSO, CL.DS_RAZAO_SOCIAL FROM T_AM_DRD_PROCESSO P, T_AM_DRD_CLIENTE CL WHERE P.CD_CLIENTE = CL.CD_CLIENTE AND P.DT_ABERTURA BETWEEN TO_DATE (?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND P.DT_FECHAMENTO IS NULL");
			ps.setString(1, dataInicial);
			ps.setString(2, dataFinal);

			rs = ps.executeQuery();

			while (rs.next()) {

				Processo p2 = new Processo();
				Cliente cl = new Cliente();

				p2.setNroProcesso(rs.getInt("NR_PROCESSO"));
				p2.setDescricao(rs.getString("DS_PROCESSO"));
				cl.setRazaoSocial(rs.getString("DS_RAZAO_SOCIAL"));
				p2.setCliente(cl);

				processo.add(p2);
			}

		} catch (Exception e) {

			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {

			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return processo;
	}

}
