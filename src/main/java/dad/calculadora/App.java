package dad.calculadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	CalculadoraController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new CalculadoraController();

		Scene scene = new Scene(controller.getView());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculadora");
		primaryStage.getIcons().add(new Image("/img/calculator-32x32.png"));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
