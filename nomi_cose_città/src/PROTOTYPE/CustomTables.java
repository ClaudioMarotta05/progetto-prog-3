package PROTOTYPE;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import BUILDER.Tabella;
public class CustomTables implements prototype{

    public TableView<Tabella> cloneTableViewStructure(TableView<Tabella> originalTableView) {
        TableView<Tabella> clonedTableView = new TableView<>();

       
        for (TableColumn<Tabella, ?> col : originalTableView.getColumns()) {
            TableColumn<Tabella, ?> clonedCol = new TableColumn<>(col.getText());
            clonedCol.setMinWidth(col.getMinWidth());
            clonedCol.setMaxWidth(col.getMaxWidth());
            clonedCol.setPrefWidth(col.getPrefWidth());
           

            clonedTableView.getColumns().add(clonedCol);
        }

        clonedTableView.setItems(originalTableView.getItems());

        return clonedTableView;
    }
}


