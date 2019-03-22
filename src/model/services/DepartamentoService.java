package model.services;

import java.util.ArrayList;
import java.util.List;

import model.beans.Departamento;

public class DepartamentoService {
	
	public List<Departamento> listar(){
		List<Departamento> lista = new ArrayList<>();
		lista.add(new Departamento(1,"Livros"));
		lista.add(new Departamento(2,"Computadores"));
		lista.add(new Departamento(3,"Eletronicos"));
		return lista;
	}

}
