
import STRATEGY.LetterStartSequentialFileSearchStrategy;
import STRATEGY.SearchStrategy;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SceneController {
    
    private TextField username;
    private PasswordField password;

    public SceneController(TextField username, PasswordField password) {
        this.username = username;
        this.password = password;
    }

    
    public void handleLoginAction(ActionEvent event) {
        if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
            SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
            boolean wordExists1 = sequentialSearch.searchWord(username.getText(),"credenziali.txt");
            boolean wordExists2 = sequentialSearch.searchWord(password.getText(), "credenziali.txt");
            if(wordExists1 && wordExists2){

                Scene2View scene2View = new Scene2View();
                scene2View.showView();
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();

     }
    }
    }

    
    public void handleSignUpAction(ActionEvent event){

        

        
        Scene3View scene3View = new Scene3View();
        scene3View.showView1();

      
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
       
    }


}