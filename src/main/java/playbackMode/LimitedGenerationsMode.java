package playbackMode;

import board.Board;
import display.GameDisplay;

import java.io.IOException;
import java.util.List;

public class LimitedGenerationsMode implements GameController {
    Board board;
    List<GameDisplay> displays;
    int generations;


    public LimitedGenerationsMode(Board board, List<GameDisplay> displays, int generations){
        this.board = board;
        this.displays = displays;
        this.generations = generations;
    }

    @Override
    public void reproduce() throws IOException {
        for(int i = 0; i < generations; i++){
            for(GameDisplay display: displays){
                display.update(board);
                board = board.nextGeneration();
            }
        }
    }
}
