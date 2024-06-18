package playbackMode;

import observer.GameObserver;

import java.io.IOException;

public interface GameController {
    void reproduce() throws IOException, InterruptedException;
    void addObserver(GameObserver observer);
    void removeObserver(GameObserver observer);
}
