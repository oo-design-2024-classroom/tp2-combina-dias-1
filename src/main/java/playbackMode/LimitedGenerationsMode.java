package playbackMode;

import board.IBoard;
import display.GameDisplay;
import java.io.IOException;
import java.util.List;

public class LimitedGenerationsMode implements GameController {
    IBoard board;
    int generations;
    List<GameDisplay> observers;

    public void addObserver(GameDisplay observer) {
        observers.add(observer);
    }
    public void removeObserver(GameDisplay observer) {
        observers.remove(observer);
    }
    public void notifyObservers() throws IOException {
        for(GameDisplay observer : observers)
            observer.update(board);
    }
    public LimitedGenerationsMode(IBoard board, int generations){
        this.board = board;
        this.generations = generations;
    }

    @Override
    public void reproduce() throws IOException {
        for(int i = 0; i < generations; i++){
            notifyObservers();
            board = board.nextGeneration();
        }
    }
}
