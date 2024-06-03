package playbackMode;

import board.Board;
import display.GameDisplay;
import java.io.IOException;
import java.util.List;

public class SimulationMode implements PlaybackMode{
    Board board;
    List<GameDisplay> displays;

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
                board = board.nextGeneration();
            }
            System.out.println("Press any key to continue, or S to stop simulation");
            if(System.in.read() == 'S'){
                stopSimulation = true;
            }
        }
    }
}
