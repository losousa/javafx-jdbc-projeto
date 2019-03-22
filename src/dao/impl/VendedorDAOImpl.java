package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.VendedorDAO;
import exception.MinhaException;
import model.beans.Departamento;
import model.beans.Vendedor;

public class VendedorDAOImpl implements VendedorDAO{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Connection conn;
	
	public VendedorDAOImpl(Connection c) {
		this.conn = c;
	}

	@Override
	public void adicionar(Vendedor v) {
		PreparedStatement stmt = null;
		try {
		String sql = "INSERT into vendedor(id,nome,email,aniversario,salario,departamentoId)values(?,?,?,?,?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, v.getId());
		stmt.setString(2, v.getNome());
		stmt.setString(3, v.getEmail());
		stmt.setDate(4, new java.sql.Date(v.getAniversario().getTime()));
		stmt.setDouble(5, v.getSalario());
		stmt.setInt(6, v.getDepartamento().getId());
		
		stmt.execute();
		System.out.println("Adicionado !");
		}catch(SQLException e) {
			throw new MinhaException(e.getMessage());
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new MinhaException(e.getMessage());
			}
		}
	}

	@Override
	public void atualizar(Vendedor v) {
		PreparedStatement stmt = null;
		String sql = "UPDATE vendedor SET nome=?,email=?,aniversario=?,salario=?,departamentoId=? WHERE id=? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getEmail());
			stmt.setDate(3, new java.sql.Date(v.getAniversario().getTime()));
			stmt.setDouble(4, v.getSalario());
			stmt.setInt(5, v.getDepartamento().getId());
			stmt.setInt(6, v.getId());
			stmt.execute();
			
			System.out.println("Atualizado");
		} catch (SQLException e) {
			throw new MinhaException(e.getMessage());
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new MinhaException(e.getMessage());
			}
		}
	}

	@Override
	public void remover(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "DELETE from vendedor WHERE id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			System.out.println("Removido.");
		} catch (SQLException e) {
			throw new MinhaException(e.getMessage());
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new MinhaException(e.getMessage());
			}
		}
	}

	@Override
	public List<Vendedor> listar() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Vendedor> lista = new ArrayList<>();
		try {
		
		String sql = "Select * from vendedor";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Departamento d = new Departamento();
			d.setId(rs.getInt("id"));
			d.setNome(rs.getString("nome"));
			Vendedor v = new Vendedor();
			v.setId(rs.getInt("id"));
			v.setNome(rs.getString("nome"));
			v.setEmail(rs.getString("email"));
			v.setAniversario(rs.getDate("aniversario"));
			v.setSalario(rs.getDouble("salario"));
			v.setDepartamento(d);
			lista.add(v);
		}
		}catch(SQLException e) {
			throw new MinhaException(e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new MinhaException(e.getMessage());
			}
		}
		
		return lista;
	}

	@Override
	public Vendedor procurarPorId(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Vendedor v = null;
		
		try {
			String sql = "SELECT id,nome,email,aniversario,salario,departamentoId from Vendedor where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Departamento d = new Departamento();
				d.setId(rs.getInt("id"));
				d.setNome(rs.getString("nome"));
				v = new Vendedor();
				v.setId(rs.getInt("id"));
				v.setNome(rs.getString("nome"));
				v.setEmail(rs.getString("email"));
				v.setAniversario(rs.getDate("aniversario"));
				v.setSalario(rs.getDouble("salario"));
				v.setDepartamento(d);
			}
		}catch(SQLException e) {
			throw new MinhaException(e.getMessage());
		}
			try {
				rs.close();
				stmt.close();
				return v;

			} catch (SQLException e) {
				throw new MinhaException(e.getMessage());
			}
			
		}
	}

