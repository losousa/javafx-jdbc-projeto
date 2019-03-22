package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.DaoFabrica;
import dao.DepartamentoDAO;
import dao.VendedorDAO;
import model.beans.Departamento;
import model.beans.Vendedor;

public class Teste {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		DepartamentoDAO dao = DaoFabrica.criarDepartamentoDAO();
				
		VendedorDAO daoo = DaoFabrica.criarVendedorDAO();
		
		Departamento dd = new Departamento(2,"Eletrodomésticos");
		try {
			Vendedor v = new Vendedor(1,"Leonardo","leonardo@gmail.com",sdf.parse("20/08/1998"),1500,dd);
			daoo.adicionar(v);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
