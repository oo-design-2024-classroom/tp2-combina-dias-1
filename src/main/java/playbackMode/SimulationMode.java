package playbackMode;

import board.Board;
import display.GameDisplay;
import observer.GameObserver;

import java.io.IOException;
import java.util.List;

public class SimulationMode implements GameController {
    Board board;
    List<GameDisplay> displays;
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
    public SimulationMode(Board board, List<GameDisplay> displays){
        this.board = board;
        this.displays = displays;
    }

    @Override
    public void reproduce() throws IOException {
        boolean stopSimulation = false;
        while (!stopSimulation){
            for(GameDisplay display: displays){
                display.update(board);
                notifyObservers();
                board = board.nextGeneration();
            }
            System.out.println("Press any key to continue, or S to stop simulation");
            if(System.in.read() == 'S'){
                stopSimulation = true;
            }
        }
    }
}
