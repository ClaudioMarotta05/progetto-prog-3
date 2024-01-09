import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.TableColumn;
import BUILDER.BuilderTabella;
import BUILDER.Tabella;
import STRATEGY.LetterStartSequentialFileSearchStrategy;
import STRATEGY.SearchStrategy;
import javafx.scene.control.TableView;

public class PlayerThreads {
    private List<TableView<Tabella>> clonedTableViews;
    private boolean running;

    public PlayerThreads(List<TableView<Tabella>> clonedTableViews) {
        this.clonedTableViews = clonedTableViews;
        this.running = true;
    }

    public void startThreads(char L) {
        for (TableView<Tabella> tableView : clonedTableViews) {
            Thread tableThread = new Thread(() -> {
                while (running) {
                    try {
                        for (TableColumn<Tabella, ?> column : tableView.getColumns()) {
                            String columnHeaderText = column.getText();
                            if (columnHeaderText.equals("nome")) {
                                SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                                String word = sequentialSearch.search(L, "nomi.txt");
                                System.out.println("Word found for 'Nome' column: " + word);
    
                                if (!word.isEmpty()) {
                                    Platform.runLater(() -> {
                                        BuilderTabella builder = new BuilderTabella();
                                        builder.setNome(word);
                                        Tabella newTableRow = builder.build();
    
                                        tableView.getItems().add(newTableRow);
                                        tableView.refresh();
                                        System.out.println("Word added to 'Nome' column in TableView");
                                    });
                                    return;
                                }
                            }
                           
                        }
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            tableThread.setDaemon(true);
            tableThread.start();
        }
    }
    


    public void stopThreads() {
        running = false;
    }
}
