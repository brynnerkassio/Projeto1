package br.com.fiap.am.druida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.druida.bean.TipoDespesa;
import br.com.fiap.am.druida.jdbc.DBManager;

public class TipoDespesaDAO {

	public List<TipoDespesa> recuperarTipoDespesa() {

		List<TipoDespesa> despesas = new ArrayList<TipoDespesa>();

		Connection conn = DBManager.getInstancia().getConexao();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT T.CD_TIPO_DESPESA, T.DS_TIPO_DESPESA FROM T_AM_DRD_TIPO_DESPESA T ORDER BY T.CD_TIPO_DESPESA ASC");

			rs = ps.executeQuery();

			while (rs.next()) {

				TipoDespesa tipoDespesa = new TipoDespesa();

				tipoDespesa.setCodigoDespesa(rs.getByte("CD_TIPO_DESPESA"));
				tipoDespesa.setTipoDespesa(rs.getString("DS_TIPO_DESPESA"));

				despesas.add(tipoDespesa);
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
		return despesas;
	}

}
