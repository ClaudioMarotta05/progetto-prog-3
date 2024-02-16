package PROTOTYPE;

import BUILDER.Tabella; // Importa la classe Tabella dal package BUILDER
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

// Definisce una classe CustomTables che implementa l'interfaccia prototype
public class CustomTables implements prototype {

    // Metodo per clonare la struttura di una TableView
    public TableView<Tabella> cloneTableViewStructure(TableView<Tabella> originalTableView) {
        // Crea una nuova TableView vuota
        TableView<Tabella> clonedTableView = new TableView<>();

        // Itera sulle colonne della TableView originale
        for (TableColumn<Tabella, ?> col : originalTableView.getColumns()) {
            // Crea una nuova TableColumn con lo stesso nome e larghezza della colonna originale
            TableColumn<Tabella, ?> clonedCol = new TableColumn<>(col.getText());
            clonedCol.setMinWidth(col.getMinWidth());
            clonedCol.setMaxWidth(col.getMaxWidth());
            clonedCol.setPrefWidth(col.getPrefWidth());

            // Imposta la PropertyValueFactory appropriata in base al nome della colonna
            // Questo sembra essere un modo per associare i nomi delle colonne ai nomi dei campi di oggetto Tabella
            // estrarre i dati per la visualizzazione nella TableView.
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

            // Aggiunge la nuova colonna alla TableView clonata
            clonedTableView.getColumns().add(clonedCol);
        }

        // Aggiorna la TableView clonata
        clonedTableView.refresh();

        // Restituisce la TableView clonata
        return clonedTableView;
    }
}
