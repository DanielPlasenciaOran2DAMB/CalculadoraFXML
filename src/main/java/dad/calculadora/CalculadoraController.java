package dad.calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CalculadoraController implements Initializable {

	@FXML
	private TextField numeroText;

	@FXML
	private BorderPane view;

	private StringProperty numero = new SimpleStringProperty();
	private Calculadora calculadora = new Calculadora();

	public CalculadoraController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		numero.bindBidirectional(numeroText.textProperty());

		MenuItem clasicoItem = new MenuItem("Clásico");
		clasicoItem.setOnAction(e -> {
			view.getStylesheets().add("/css/clasicocss.css");
		});

		MenuItem modernoItem = new MenuItem("Moderno");
		modernoItem.setOnAction(e -> {
			view.getStylesheets().add("/css/modernocss.css");
		});

		ContextMenu menu = new ContextMenu(clasicoItem, modernoItem);

		view.setOnContextMenuRequested(e -> {
			menu.show(view, e.getScreenX(), e.getScreenY());
		});
	}

	@FXML
	void onBorrarAction(ActionEvent event) {
		calculadora.borrar();
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onBorrarTodoAction(ActionEvent event) {
		calculadora.borrarTodo();
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onCeroAction(ActionEvent event) {
		calculadora.insertar('0');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onCincoAction(ActionEvent event) {
		calculadora.insertar('5');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onCuatroAction(ActionEvent event) {
		calculadora.insertar('4');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onDividirAction(ActionEvent event) {
		calculadora.operar(Calculadora.DIVIDIR);
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onDosAction(ActionEvent event) {
		calculadora.insertar('2');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onIgualAction(ActionEvent event) {
		calculadora.operar(Calculadora.IGUAL);
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onMultiplicarAction(ActionEvent event) {
		calculadora.operar(Calculadora.MULTIPLICAR);
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onNueveAction(ActionEvent event) {
		calculadora.insertar('9');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onOchoAction(ActionEvent event) {
		calculadora.insertar('8');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onPuntoAction(ActionEvent event) {
		calculadora.insertarComa();
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onRestaAction(ActionEvent event) {
		calculadora.operar(Calculadora.RESTAR);
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onSeisAction(ActionEvent event) {
		calculadora.insertar('6');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onSieteAction(ActionEvent event) {
		calculadora.insertar('7');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onSumaAction(ActionEvent event) {
		calculadora.operar(Calculadora.SUMAR);
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onTresAction(ActionEvent event) {
		calculadora.insertar('3');
		numero.set(calculadora.getPantalla());
	}

	@FXML
	void onUnoAction(ActionEvent event) {
		calculadora.insertar('1');
		numero.set(calculadora.getPantalla());
	}

	public BorderPane getView() {
		return view;
	}
}
