package playbackMode;

import board.IBoard;
import display.GameDisplay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimulationMode implements GameController {
    IBoard board;
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
    public SimulationMode(IBoard board){
        this.board = board;
    }

    @Override
    public void reproduce() throws IOException {
        boolean stopSimulation = false;
        while (!stopSimulation){
            board = board.nextGeneration();
            notifyObservers();
            System.out.println("Press any key to continue, or S to stop simulation");
            if(System.in.read() == 'S'){
                stopSimulation = true;
            }
        }
    }
}
