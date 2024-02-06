package MVC;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


public class Scene3controller {
    
    private TextField username;
    private TextField password;
    private TextField mail;
    private RadioButton maschio;
    private RadioButton femmina;
    private RadioButton altro;
    private model1 model;
   

    

   

    public Scene3controller(model1 model) {
       this.model = model;
    }

    public void back(ActionEvent event){

       
        Scene1View scene = new Scene1View(model);
        scene.showView();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
    }
    

    
    public void signup(ActionEvent event) {
       
        if (!username.getText().isEmpty() && !password.getText().isEmpty() && !mail.getText().isEmpty()) {
            
            writeToFile("nomi_cose_città/src/dizionario/credenziali.txt");}

           
            model.setUsername(username.getText());
            model.setPassword(password.getText());
            model.setMail(mail.getText());


            
            Scene2View scene2View = new Scene2View(model);
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
               
                writer.newLine();
                writer.newLine();
                writer.write(username.getText());
                writer.newLine();
                writer.write(password.getText());
                writer.newLine();
                writer.write(mail.getText());
                writer.newLine();

                
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
