package playbackMode;
import board.IBoard;
import display.GameDisplay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContinuousMode implements GameController {
    IBoard board;
    float sleepTime;
    List<GameDisplay> observers = new ArrayList<>();
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
    public ContinuousMode(IBoard board, float sleepTimeInSeconds){
        this.board = board;
        this.sleepTime = sleepTimeInSeconds;
    }

    @Override
    public void reproduce() throws InterruptedException, IOException {
        while (true){
            board = board.nextGeneration();
            notifyObservers();
            Thread.sleep((long) (sleepTime * 1000));
        }
    }
}