package playbackMode;
import board.IBoard;
import display.GameDisplay;
import observer.GameObserver;

import java.io.IOException;
import java.util.List;

public class ContinuousMode implements GameController {
    IBoard board;
    List<GameDisplay> displays;
    float sleepTime;
    List<GameObserver> observers;
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for(GameObserver observer : observers)
            observer.update(board);
    }
    public ContinuousMode(IBoard board, List<GameDisplay> displays, float sleepTimeInSeconds){
        this.board = board;
        this.displays = displays;
        this.sleepTime = sleepTimeInSeconds;
    }

    @Override
    public void reproduce() throws InterruptedException, IOException {
        while (true){
            for(GameDisplay display: displays){
                display.update(board);
                board = board.nextGeneration();
                notifyObservers();
            }
            Thread.sleep((long) (sleepTime * 1000));
        }
    }
}