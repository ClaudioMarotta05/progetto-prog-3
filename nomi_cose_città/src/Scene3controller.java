import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Scene3controller {
    private TextField username;
    private TextField password;
    private TextField mail;
    private RadioButton maschio;
    private RadioButton femmina;
    private RadioButton altro;
   

    

   

    public Scene3controller(TextField username, TextField password, TextField mail,RadioButton maschio,RadioButton femmina,RadioButton altro) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.maschio = maschio;
        this.femmina = femmina;
        this.altro = altro;
    }

    

    
    public void signup(ActionEvent event) {
        // Verifica che i campi di testo non siano vuoti
        if (!username.getText().isEmpty() && !password.getText().isEmpty() && !mail.getText().isEmpty()) {
            // Scrivi le credenziali su un file nella cartella "dizionario"
            writeToFile("nomi_cose_città/src/dizionario/credenziali.txt");}

            Scene2View scene2View = new Scene2View();
            scene2View.showView();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();


    }


    
    private void writeToFile(String filePath) {
        try {

            // Verifica se il file esiste già, in caso contrario crea un nuovo file
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Usa BufferedWriter in modalità di append per aggiungere i dati al file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                // Scrivi i dati del form nel file
                writer.newLine();
                writer.newLine();
                writer.write(username.getText());
                writer.newLine();
                writer.write(password.getText());
                writer.newLine();
                writer.write(mail.getText());
                writer.newLine();

                 // Aggiungi i dettagli dei radio buttons
                 if (maschio.isSelected()) {
                    writer.write("Genere: Maschio");
                } else if (femmina.isSelected()) {
                    writer.write("Genere: Femmina");
                } else if (altro.isSelected()) {
                    writer.write("Genere: Altro");
                }
                

                System.out.println("Dati aggiunti a " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
