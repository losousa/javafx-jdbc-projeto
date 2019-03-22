package model.services;

import java.util.List;

import dao.DaoFabrica;
import dao.DepartamentoDAO;
import model.beans.Departamento;

public class DepartamentoService {
	
	private DepartamentoDAO dao = DaoFabrica.criarDepartamentoDAO();
	
	public List<Departamento> listar(){
		return dao.listar();
	}

}
