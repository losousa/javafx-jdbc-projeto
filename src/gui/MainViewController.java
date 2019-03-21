package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuVendedor;
	
	@FXML
	private MenuItem menuDepartamento;
	
	@FXML
	private MenuItem menuAbout;
	
	@FXML
	public void onMenuVendedorAction() {
		System.out.println("Vendedor");
	}
	
	public void onMenuDepartamentoAction() {
		System.out.println("Departamento");
	}

	public void onMenuAboutAction() {
		System.out.println("Sobre");
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
