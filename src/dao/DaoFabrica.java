package dao;

import conexao.ConnectionFactory;
import dao.impl.DepartamentoDAOImpl;
import dao.impl.VendedorDAOImpl;

public class DaoFabrica {
	
	public static DepartamentoDAO criarDepartamentoDAO() {
		return new DepartamentoDAOImpl(ConnectionFactory.getConnection());
	}
	
	public static VendedorDAO criarVendedorDAO() {
		return new VendedorDAOImpl(ConnectionFactory.getConnection());
	}

}
