package playbackMode;

import display.GameDisplay;
import java.io.IOException;

public interface GameController {
    void reproduce() throws IOException, InterruptedException;
    void addObserver(GameDisplay observer);
    void removeObserver(GameDisplay observer);
}
