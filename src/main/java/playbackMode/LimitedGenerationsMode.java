package playbackMode;

import board.IBoard;
import display.GameDisplay;
import observer.GameObserver;

import java.io.IOException;
import java.util.List;

public class LimitedGenerationsMode implements GameController {
    IBoard board;
    List<GameDisplay> displays;
    int generations;
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
    public LimitedGenerationsMode(IBoard board, List<GameDisplay> displays, int generations){
        this.board = board;
        this.displays = displays;
        this.generations = generations;
    }

    @Override
    public void reproduce() throws IOException {
        for(int i = 0; i < generations; i++){
            for(GameDisplay display: displays){
                display.update(board);
                notifyObservers();
                board = board.nextGeneration();
            }
        }
    }
}
