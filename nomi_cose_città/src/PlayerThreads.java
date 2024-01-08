import java.util.List;




import javafx.scene.control.TableColumn; 

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
                            System.out.println("Table " + tableView.getId() + " - Column Text: " + columnHeaderText);
                            if (columnHeaderText.equals("Nome")) {
                                SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                                String word = sequentialSearch.search(L, "nomi.txt");
                                System.out.println("Parola Trovata " + word);
                        
                                // Ottieni la riga corretta dalla tabella (ad es. dalla selezione o dagli item)
                                Tabella rigaSelezionata = tableView.getSelectionModel().getSelectedItem(); // Esempio: riga selezionata
                        
                                // Verifica se la riga è valida
                                if (rigaSelezionata != null) {
                                    // Imposta la parola trovata nella cella della colonna "Nome"
                                    rigaSelezionata.setNome(word);
                        
                                    // Aggiorna la tabella per riflettere le modifiche
                                    tableView.refresh(); // Aggiorna la tabella
                                }
                                return;
                            }
                        }
                        
                        
                        
                        
                        
                        // Simulate some processing time
                        Thread.sleep(2000); // Sleep for 2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            tableThread.setDaemon(true); // Set thread as daemon to stop when the application exits
            tableThread.start();
        }
    }

    public void stopThreads() {
        running = false;
    }
}
