package dao;

import java.util.List;

import model.beans.Vendedor;

public interface VendedorDAO {
	
	void adicionar(Vendedor v);
	void atualizar(Vendedor v);
	void remover(int id);
	List<Vendedor> listar();
	Vendedor procurarPorId(int id);

}
