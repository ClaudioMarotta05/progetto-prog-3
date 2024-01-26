package PROTOTYPE;
import MVC.Tabella;
import javafx.scene.control.TableView;

public interface prototype extends Cloneable {
    TableView<Tabella> cloneTableViewStructure(TableView<Tabella> tableViewOriginale);
}
