package factory.game;

import playbackMode.GameController;

public interface GameVariantFactory {
    GameController createController(String playbackMode, String displays, int rows, int cols, String initialBoardPositions);
}
