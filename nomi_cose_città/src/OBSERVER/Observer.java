package OBSERVER;

import BUILDER.Tabella;
import javafx.scene.control.TableView;


public interface Observer {
     void onTableCompleted(TableView<Tabella> completedTable);
}


 