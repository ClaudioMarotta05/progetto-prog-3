import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

import java.util.List;
import java.util.Random;

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

    private int insertedWords = 0;
   

   

    public void startThreads(char L) {
        for (TableView<Tabella> tableView : clonedTableViews) {
            Thread tableThread = new Thread(() -> {
                while (running) {
                    try {
                        for (TableColumn<Tabella, ?> column : tableView.getColumns()) {

                            
                            String columnHeaderText = column.getText();
                            if ("tot".equalsIgnoreCase(columnHeaderText)) {
                                continue; 
                            }

                           

                            int numberOfColumns = tableView.getColumns().size();

                            insertedWords++;
                            if (insertedWords + 1 >= numberOfColumns) {
                                stopThreads();
                            }
                            
                            int randomDelay = new Random().nextInt(5) + 2;
                            Thread.sleep(randomDelay * 1000);

                             searchAndAddData(tableView, columnHeaderText, L);

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

    private void searchAndAddData(TableView<Tabella> tableView, String columnHeaderText, char L) {
        SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
        String word = sequentialSearch.search(L, columnHeaderText.toLowerCase() + ".txt");
        System.out.println("Word found for '" + columnHeaderText + "' column: " + word);

        if (!word.isEmpty()) {
            Platform.runLater(() -> {
               
                 ObservableList<Tabella> TT = tableView.getItems();
        BuilderTabella builder = new BuilderTabella();

        Tabella currentRow;
        if (TT.isEmpty()) {
            currentRow = builder
                .setNome("")
                .setCosa("")
                .setCitta("")
                .setFrutta("")
                .build();
            TT.add(currentRow);
        } else {
            currentRow = TT.get(0);
        }

        // Impostazione della parola nella colonna corrispondente in base al testo dell'intestazione
        switch (columnHeaderText.toLowerCase()) {
            case "nome":
                currentRow.setNome(word);
                break;
            case "cosa":
                currentRow.setCosa(word);
                break;
            case "citta":
                currentRow.setCitta(word);
                break;
            case "frutta":
                currentRow.setFrutta(word);
                break;
            default:
                break;
                }

                


                

             
                tableView.refresh();
            });
        }
    }

    public void stopThreads() {
        running = false;
        
    }
}
