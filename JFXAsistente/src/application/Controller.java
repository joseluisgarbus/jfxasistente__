package application;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller{
	
	/**
	 * 
	 * Creacion de paneles y count label
	 */
	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private Label countLabel;
	
	


	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
	}

	int showSlide = 0;

	
	/**
	 * 
	 * Metodo que esconde los paneles que no tienen que salir en un det. momento
	 * por pantalla, por lo que los saca fuera del tamaño del panel y muestra el que 
	 * corresponde. Este metodo funcionara con el boton de seguir adelante
	 */
	@FXML
	void nextAction() {

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 1) {

			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");

		} else {
			System.out.println("No more slides");
		}

	}
	
	/**
	 * 
	 * Metodo que esconde los paneles que no tienen que salir en un det. momento
	 * por pantalla, por lo que los saca fuera del tamaño del panel y muestra el que 
	 * corresponde. Este metodo funcionara con el boton de volver hacia atras
	 */

	@FXML
	void backAction() {

		if (showSlide == 0) {
			System.out.println("No more slides");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
		}

	}

}