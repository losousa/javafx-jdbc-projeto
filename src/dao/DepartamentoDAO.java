package dao;

import java.util.List;

import model.beans.Departamento;

public interface DepartamentoDAO {
	
	void adicionar(Departamento d);
	void atualizar(Departamento d);
	void remove(int id);
	List<Departamento> listar();
	Departamento procurarPorId(int id);

}
