package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DepartamentoDAO;
import exception.MinhaException;
import model.beans.Departamento;

public class DepartamentoDAOImpl implements DepartamentoDAO {

	private Connection conn;

	public DepartamentoDAOImpl(Connection c) {
		conn = c;
	}

	@Override
	public void adicionar(Departamento d) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT into departamento(id,nome) values(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, d.getId());
			stmt.setString(2, d.getNome());

			stmt.execute();
			System.out.println("Adicionado");
		} catch (SQLException e) {
			throw new MinhaException(e.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Departamento d) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "UPDATE departamento SET nome = ? WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, d.getNome());
			stmt.setInt(2, d.getId());

			int linhasAfetadas = stmt.executeUpdate();
			System.out.println("Linhas Afetadas :" + linhasAfetadas);
		} catch (SQLException e) {
			throw new MinhaException(e.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remove(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "DELETE from departamento where id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.execute();
			
			System.out.println("Removido.");
		} catch (SQLException e) {
			throw new MinhaException(e.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Departamento> listar() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Departamento> lista = new ArrayList<>();
		String sql = "SELECT * from departamento";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Departamento d = new Departamento();
				d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				lista.add(d);
			}
		} catch (SQLException e) {
			throw new MinhaException(e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lista;
	}

	@Override
	public Departamento procurarPorId(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "Select * from departamento where id = ?";
		Departamento d = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				d = new Departamento();
				d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			throw new MinhaException(e.getMessage());
		}
		return d;
	}

}
