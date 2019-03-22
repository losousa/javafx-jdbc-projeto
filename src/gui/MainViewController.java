package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartamentoService;

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
		carregarTela("/gui/DepartamentoList.fxml", (DepartamentoController controller) -> {
			controller.setDepartamentoService(new DepartamentoService());
			controller.atualizarTableView();
		});
	}

	public void onMenuAboutAction() {
		carregarTela("/gui/About.fxml",x->{});
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	public synchronized <T> void carregarTela(String nomeDaView,Consumer<T> acaoDeInicializacao) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeDaView));
			VBox novoVBox = loader.load();
			
			Scene telaPrincipal = Main.mostarCena();
			VBox vboxPrincipal = (VBox) ((ScrollPane) telaPrincipal.getRoot()).getContent();
			
			Node menuPrincipal = vboxPrincipal.getChildren().get(0);
			vboxPrincipal.getChildren().clear();
			vboxPrincipal.getChildren().add(menuPrincipal);
			vboxPrincipal.getChildren().addAll(novoVBox.getChildren());
			
			T controll = loader.getController();
			acaoDeInicializacao.accept(controll);
		} catch (IOException e) {
			Alerts.mostrarAlert("Exception IO","Erro de carregar View", e.getMessage(), AlertType.ERROR);
		} 
	}
}
