package playbackMode;
import board.Board;
import display.GameDisplay;

import java.io.IOException;
import java.util.List;

public class ContinuousMode implements GameController {
    Board board;
    List<GameDisplay> displays;
    float sleepTime;

    public ContinuousMode(Board board, List<GameDisplay> displays, float sleepTimeInSeconds){
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
            }
            Thread.sleep((long) (sleepTime * 1000));
        }
    }
}