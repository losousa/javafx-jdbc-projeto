package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartamentoFormController implements Initializable{
	@FXML
	private Button salvar;
	
	@FXML
	private Button cancelar;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField nome;
	
	@FXML
	private Label erroNome;
	
	@FXML
	public void onSalvar() {
		System.out.println("Salvou !");
	}
	
	@FXML
	public void onCancelar() {
		System.out.println("Cancelou");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
 		
	}

}
