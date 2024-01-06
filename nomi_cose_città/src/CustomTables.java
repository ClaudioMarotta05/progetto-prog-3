
import javafx.scene.control.TableView;
import BUILDER.Tabella;
public class CustomTables implements prototype{

    public TableView<Tabella> copiaTableView(TableView<Tabella> tableViewOriginale) {
        TableView<Tabella> nuovaTableView = new TableView<Tabella>();

        // Copia le colonne dalla TableView originale alla nuova TableView
        nuovaTableView.getColumns().addAll(tableViewOriginale.getColumns());

        return nuovaTableView; }
}
