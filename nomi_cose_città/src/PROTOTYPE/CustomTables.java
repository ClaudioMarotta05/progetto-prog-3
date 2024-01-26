package PROTOTYPE;

import MVC.Tabella;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class CustomTables implements prototype{

    public TableView<Tabella> cloneTableViewStructure(TableView<Tabella> originalTableView) {
        TableView<Tabella> clonedTableView = new TableView<>();

       
        for (TableColumn<Tabella, ?> col : originalTableView.getColumns()) {
            TableColumn<Tabella, ?> clonedCol = new TableColumn<>(col.getText());
            clonedCol.setMinWidth(col.getMinWidth());
            clonedCol.setMaxWidth(col.getMaxWidth());
            clonedCol.setPrefWidth(col.getPrefWidth());

            if (col.getText().equals("nome")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
            } else if (col.getText().equals("cosa")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("cosa"));
            } else if (col.getText().equals("citta")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("citta"));
            } else if (col.getText().equals("frutta")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("frutta"));
            }else if (col.getText().equals("tot")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("tot"));
            }

           

            clonedTableView.getColumns().add(clonedCol);
        }

       
        clonedTableView.refresh();

        return clonedTableView;
    }
}


