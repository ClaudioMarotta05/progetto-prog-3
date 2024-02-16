package PROTOTYPE;

import BUILDER.Tabella; // Importa la classe Tabella dal package BUILDER
import javafx.scene.control.TableView;

// Definisce un'interfaccia chiamata prototype che estende Cloneable
public interface prototype extends Cloneable {

    // Metodo per clonare la struttura di una TableView
    // Prende come argomento una TableView originale che contiene oggetti di tipo Tabella
    // Restituisce una TableView che rappresenta una copia della struttura della TableView originale
    TableView<Tabella> cloneTableViewStructure(TableView<Tabella> tableViewOriginale);
}
