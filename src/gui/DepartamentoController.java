package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.beans.Departamento;

public class DepartamentoController implements Initializable{

	@FXML
	private TableView<Departamento> tableViewDepartamento;
	
	@FXML
	private Button botaoNovo;
	
	@FXML
	private TableColumn<Departamento,Integer> colunaId;
	
	@FXML
	private TableColumn<Departamento,String> colunaNome;
	
	public void onNovaAcao() {
		System.out.println("Nova Acao");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		inicializarNodes();
	}

	private void inicializarNodes() {
		colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		Stage stage = (Stage) Main.mostarCena().getWindow();
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
	}

}
