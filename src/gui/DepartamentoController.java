package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.beans.Departamento;
import model.services.DepartamentoService;

public class DepartamentoController implements Initializable{
	
	private DepartamentoService service;
	
	private ObservableList<Departamento> listaObservacao;
	
	public void setDepartamentoService(DepartamentoService service) {
		this.service = service;
	}

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

	public void atualizarTableView() {
		if(service == null) {
			throw new IllegalStateException("Serviço nulo");
		}
		List<Departamento> lista = service.listar();
		listaObservacao = FXCollections.observableArrayList(lista);
		tableViewDepartamento.setItems(listaObservacao);
	}
}
