package factory;

import board.Board;
import display.GameDisplay;
import playbackMode.GameController;
import rule.Rule;

import java.util.List;

public class GameCreator {
    public static GameController getGame(String variant, String playbackMode, String displays, int rows, int cols, String initialBoardPositions) {
        List<Rule> rules = new RulesFactory().factory(variant);
        List<GameDisplay> gameDisplaysList = DisplaysFactory.factory(displays);
        BoardFactory boardFactory = new BoardFactory();
        Board board = boardFactory.factory(rows, cols, initialBoardPositions, rules, new CellFactory());
        return new PlaybackModeFactory().getPlaybackMode(playbackMode, board, gameDisplaysList);
    }
}
