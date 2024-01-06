import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

public class Scene2Controller {

    @FXML
    private MenuButton menu;

    private boolean nome = false;
    private boolean cose = false;
    private boolean citta = false;
    private boolean frutta = false;

    @FXML
    public void setCat1(ActionEvent event) {
        this.nome = !this.nome;
        System.out.println("Valore di nome: " + this.nome);
    }

    @FXML
    public void setCat2(ActionEvent event) {
        this.cose = !this.cose;
        System.out.println("Valore di nome: " + this.cose);
    }

    @FXML
    public void setCat3(ActionEvent event) {
        this.citta = !this.citta;
        System.out.println("Valore di nome: " + this.citta);
    }

    @FXML
    public void setCat4(ActionEvent event) {
        this.frutta = !this.frutta;
        System.out.println("Valore di nome: " + this.frutta);
    }

    public boolean getNome() {
        return this.nome;
    }

    public boolean getCose() {
        return this.cose;
    }

    public boolean getCitta() {
        return this.citta;
    }

    public boolean getFrutta() {
        return this.frutta;
    }

    @FXML
    private void playGame(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
            Parent root = loader.load();

            MainSceneController mainController = loader.getController();

    // Passaggio dei valori booleani
    mainController.setColValues(getNome(), getCose(), getCitta(), getFrutta());
    
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
