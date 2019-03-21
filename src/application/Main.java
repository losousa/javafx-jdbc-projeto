package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene cenaPrincipal;
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scroll = loader.load();
			
			scroll.setFitToHeight(true);
			scroll.setFitToWidth(true);
			cenaPrincipal = new Scene(scroll);
			primaryStage.setScene(cenaPrincipal);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene mostarCena() {
		return cenaPrincipal;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
