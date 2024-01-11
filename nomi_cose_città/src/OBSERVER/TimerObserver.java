package OBSERVER;

import BUILDER.Tabella;

import java.util.ArrayList;
import java.util.List;


import javafx.scene.control.TableView;


public class TimerObserver implements Observer {
    private List<TimerObserver> observers = new ArrayList<>();

    public void addObserver(TimerObserver observer) {
        observers.add(observer);
    }

    public void notifyTableCompleted(TableView<Tabella> completedTable) {
        for (TimerObserver observer : observers) {
            observer.onTableCompleted(completedTable);
        }
    }

    @Override
    public void onTableCompleted(TableView<Tabella> completedTable) {
       
    }
}
