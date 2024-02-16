package MVC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

// Questa classe gestisce le azioni per la terza scena dell'applicazione
public class Scene3controller {
    
    private String username;
    private String password;
    private String mail;
    private model1 model;
   

    // Costruttore della classe
    public Scene3controller(model1 model) {
       this.model = model; // Inizializza il modello
    }

    // Metodo per tornare alla schermata di registrazione
    public void back(ActionEvent event){
        // Crea una nuova istanza della schermata di registrazione
        Scene1View scene = new Scene1View(model);
        scene.showView();

        // Chiude la finestra attuale
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    // Metodo per gestire la registrazione dell'utente
    public void signup(ActionEvent event) {
        // Ottiene le informazioni inserite dall'utente dal modello
        username = model.getUsername();
        password = model.getPassword();
        mail = model.getMail();

        // Verifica se tutti i campi sono stati compilati
        if (!username.isEmpty() && !password.isEmpty() && !mail.isEmpty()) {
            // Scrive i dati nel file delle credenziali
            writeToFile("nomi_cose_città/src/dizionario/credenziali.txt");

            // Passa alla schermata successiva
            Scene2View scene2View = new Scene2View(model);
            scene2View.showView();

            // Chiude la finestra attuale
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        }
    }
    
    // Metodo per scrivere i dati nel file delle credenziali
    private void writeToFile(String filePath) {
        try {
            // Verifica se il file esiste già, altrimenti crea un nuovo file
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Usa BufferedWriter in modalità di append per aggiungere i dati al file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.newLine();
                writer.newLine();
                writer.write(username);
                writer.newLine();
                writer.write(password);
                writer.newLine();
                writer.write(mail);
                writer.newLine();
                
                System.out.println("Dati aggiunti a " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura dei dati nel file: " + e.getMessage());
        }
    }
}
