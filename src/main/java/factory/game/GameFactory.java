package factory.game;

import playbackMode.GameController;

public class GameFactory{
    String playbackMode;
    String displays;
    int rows;
    int cols;
    String variant;
    String initialBoardPositions;

    public GameFactory(String variant, String playbackMode, String displays, int rows, int cols, String initialBoardPositions) {
        this.playbackMode = playbackMode;
        this.displays = displays;
        this.rows = rows;
        this.cols = cols;
        this.initialBoardPositions = initialBoardPositions;
        this.variant = variant;
    }

    public GameController createController() {
        return switch (variant) {
            case "classic" -> //TODO
                    new ClassicGameFactory().createController(playbackMode, displays, rows, cols, initialBoardPositions);
            case "immigration" -> //TODO
                    new ImmigrationGameFactory().createController(playbackMode, displays, rows, cols, initialBoardPositions);
            case "starWars" -> //TODO
                    new StarWarsGameFactory().createController(playbackMode, displays, rows, cols, initialBoardPositions);
            case "briansBrain" -> //TODO
                    new BriansBrainGameFactory().createController(playbackMode, displays, rows, cols, initialBoardPositions);
            default -> throw new IllegalArgumentException("Invalid variant");
        };
    }
}
