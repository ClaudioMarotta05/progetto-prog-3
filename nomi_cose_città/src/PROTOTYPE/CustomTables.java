package PROTOTYPE;

import BUILDER.Tabella; // Importa la classe Tabella dal package BUILDER
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Questa classe implementa l'interfaccia Prototype e fornisce un'implementazione per clonare la struttura di una TableView.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class CustomTables implements prototype {

    /**
     * Clona la struttura di una TableView.
     *
     * @param originalTableView La TableView originale da clonare.
     * @return Una TableView che rappresenta una copia della struttura della TableView originale.
     */
    @Override
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
            } else if (col.getText().equals("verbi")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("verbi"));
            } else if (col.getText().equals("animali")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("animali"));
            } else if (col.getText().equals("piante")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("piante"));
            } else if (col.getText().equals("cantanti")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("cantanti"));
            } else if (col.getText().equals("nazioni")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("nazioni"));
            } else if (col.getText().equals("mestieri")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("mestieri"));
            } else if (col.getText().equals("celebrita")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("celebrita"));
            } else if (col.getText().equals("tot")) {
                clonedCol.setCellValueFactory(new PropertyValueFactory<>("tot"));
            }

            clonedTableView.getColumns().add(clonedCol);
        }

        clonedTableView.refresh();

        return clonedTableView;
    }
}