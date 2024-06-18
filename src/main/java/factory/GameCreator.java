package factory;

import board.IBoard;
import playbackMode.GameController;
import rule.Rule;

import java.util.List;

public class GameCreator {
    public static GameController getGame(String variant, String playbackMode, int rows, int cols, String initialBoardPositions) {
        List<Rule> rules = new RulesFactory().factory(variant);
        BoardFactory boardFactory = new BoardFactory();
        IBoard board = boardFactory.factory(rows, cols, initialBoardPositions, rules, new CellFactory());
        return new PlaybackModeFactory().getPlaybackMode(playbackMode, board);
    }
}
