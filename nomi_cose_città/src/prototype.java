import BUILDER.Tabella;
import javafx.scene.control.TableView;

public interface prototype {
    TableView<Tabella> copiaTableView(TableView<Tabella> tableViewOriginale);
}
