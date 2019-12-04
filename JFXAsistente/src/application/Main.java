package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	Stage stage;
	

	
	/**
	 * Arrancamos la pantalla
	 * Importante incorporar en propiedades(properties) el jfoenix
	 * Importante, si trabajamos con SceneBuilder 8, trabajaremos con Java 8, para un buen
	 * funcionamiento del programa
	 * 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			mainWindow();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		launch(args);
	}

	/**
	 * 
	 * Conectar el scenebuilder mediante fxmlloader con el nombre del archivo del scenebuilder
	 * Debemos meter el scenebuilder desde archivos, dentro del proyecto.
	 *
	 */
	public void mainWindow() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("jfxasistente.fxml"));
			AnchorPane pane = loader.load();
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(new Scene(pane));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}