package br.com.fiap.am.druida.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.druida.bean.TipoTarefa;
import br.com.fiap.am.druida.jdbc.DBManager;

public class TipoTarefaDAO {

	public List<TipoTarefa> recuperarTipoTarefa() {

		List<TipoTarefa> tarefas = new ArrayList<TipoTarefa>();

		Connection conn = DBManager.getInstancia().getConexao();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn.setAutoCommit(false);

			ps = conn
					.prepareStatement("SELECT T.CD_TIPO_TAREFA, T.DS_TIPO_TAREFA FROM T_AM_DRD_TIPO_TAREFA T ORDER BY T.CD_TIPO_TAREFA ASC");

			rs = ps.executeQuery();

			while (rs.next()) {

				TipoTarefa tipoTarefa = new TipoTarefa();

				tipoTarefa.setCodigoTarefa(rs.getByte("CD_TIPO_TAREFA"));
				tipoTarefa.setTipoTarefa(rs.getString("DS_TIPO_TAREFA"));

				tarefas.add(tipoTarefa);
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
		return tarefas;
	}

}
