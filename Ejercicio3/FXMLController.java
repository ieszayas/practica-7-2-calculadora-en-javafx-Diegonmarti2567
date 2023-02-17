package Ejercicio3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 */
public class FXMLController implements Initializable {

    @FXML
    private TextArea result;
    @FXML
    private Button mult;
    @FXML
    private Button div;

    @FXML
    private Button mas;

    @FXML
    private Button borrar;
    @FXML
    private Button igual;
    @FXML
    private Button menos;
    private boolean Digito = false;
    private int numoperandos = 0;
    private double operador1, operador2;
    private char operador = ' ';
    @FXML
    private Button div11113;
    @FXML
    private Button div11114;
    @FXML
    private Button div11116;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void numero(ActionEvent event) {
        String numero = ((Button) event.getSource()).getText();
        numPantalla(numero);
    }

    @FXML
    private void btnc(ActionEvent event) {
        Digito = false;
        numoperandos = 0;
        operador1 = 0;
        operador2 = 0;
        result.setText(null);
    }

    @FXML
    private void digitos(ActionEvent event) {
        String digito = ((Button) event.getSource()).getText();
        operacion(digito);
    }

    private void numPantalla(String digito) {
        if (!Digito) {
            result.setText(digito);
            Digito = true;
        } else {
            result.setText(result.getText() + digito);
        }
    }

    private void operacion(String op) {
        if (numoperandos == 0) {
            operador1 = Double.parseDouble(result.getText());
            operador = op.charAt(0);
            numoperandos++;
            Digito = false;
        } else {
            operador2 = Double.parseDouble(result.getText());
            double resultado = 0.0;
            switch (operador) {
                case '+':
                    resultado = operador1 + operador2;
                    break;
                case '-':
                    resultado = operador1 - operador2;
                    break;
                case 'x':
                    resultado = operador1 * operador2;
                    break;
                case '/':
                    if (operador2 == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("División entre cero");
                        alert.setContentText("No se puede dividir entre cero");
                        alert.showAndWait();
                        result.setText("");
                        operador1 = 0;
                        operador2 = 0;
                        operador = ' ';
                        numoperandos = 0;
                        Digito = false;
                        return;
                    } else {
                        resultado = operador1 / operador2;
                    }
                    break;
                case '=':
                    resultado = operador1;
                    break;

            }
            operador1 = resultado;
            result.setText(Double.toString(resultado));
            operador = op.charAt(0);
            Digito = false;
        }
    }

}
