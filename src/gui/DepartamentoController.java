package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
	
	@FXML
	public void onNovaAcao(ActionEvent event) {
		Stage parentStage = Utils.telaAtual(event);
		criarDialogoFormulario("/gui/DepartamentoForm.fxml", parentStage);
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
	
	private void criarDialogoFormulario(String nomePagina,Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomePagina));
			Pane painel = loader.load();
			
			Stage dialogoDeTela = new Stage();
			dialogoDeTela.setTitle("Dados de Departamento");
			dialogoDeTela.setScene(new Scene(painel));
			dialogoDeTela.setResizable(false);
			dialogoDeTela.initOwner(parentStage);
			dialogoDeTela.initModality(Modality.WINDOW_MODAL);
			dialogoDeTela.showAndWait();
			
		}catch(IOException e) {
			Alerts.mostrarAlert("IO Exception", "Erro de carregar tela", e.getMessage(), AlertType.ERROR);
		}
	}
}
