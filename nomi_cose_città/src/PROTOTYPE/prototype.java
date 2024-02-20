package PROTOTYPE;

import BUILDER.Tabella; // Importa la classe Tabella dal package BUILDER
import javafx.scene.control.TableView;

/**
 * Questa interfaccia definisce un prototipo che estende Cloneable.
 * Viene utilizzata per clonare la struttura di una TableView.
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public interface prototype extends Cloneable {

    /**
     * Clona la struttura di una TableView.
     *
     * @param tableViewOriginale La TableView originale da clonare.
     * @return Una TableView che rappresenta una copia della struttura della TableView originale.
     */
    TableView<Tabella> cloneTableViewStructure(TableView<Tabella> tableViewOriginale);
}
