package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionMySQL;
import model.Destino;

public class DestinoDAO {

	// create
	public void create(Destino destino) {

		String sql = "insert into Destino (nome_Destino, preco_Destino, data_Destino) values (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome_Destino());
			pstm.setFloat(2, destino.getPreco_Destino());
			pstm.setDate(3, new java.sql.Date(destino.getData_Destino().getTime()));
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Destino> read() {
		List<Destino> destinos = new ArrayList<Destino>();
		String sql = "select * from Destino";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino destino = new Destino();

				destino.setId_Destino(rset.getInt("id_Destino"));
				destino.setNome_Destino(rset.getString("nome_Destino"));
				destino.setPreco_Destino(rset.getFloat("preco_Destino"));
				destino.setData_Destino(rset.getDate("data_Destino"));

				destinos.add(destino);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return destinos;
	}

	// update
	public void update(Destino destino) {
		String sql = "UPDATE Destino SET nome_Destino = ?, preco_Destino = ?,  data_Destino = ? WHERE id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome_Destino());
			pstm.setFloat(2, destino.getPreco_Destino());
			pstm.setDate(3,  new Date(destino.getData_Destino().getTime()));
			pstm.setInt(4, destino.getId_Destino());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Destino WHERE id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Destino readById(int id) {
		Destino destino = new Destino();
		String sql = "select * from Destino WHERE id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			destino.setId_Destino(rset.getInt("id_Destino"));
			destino.setNome_Destino(rset.getString("nome_Destino"));
			destino.setPreco_Destino(rset.getFloat("preco_Destino"));
			destino.setData_Destino(rset.getDate("data_Destino"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destino;
	}

}
