package OBSERVER;

import MVC.Tabella;
import javafx.scene.control.TableView;


public interface Observer {
     void onTableCompleted(TableView<Tabella> completedTable);
}


 