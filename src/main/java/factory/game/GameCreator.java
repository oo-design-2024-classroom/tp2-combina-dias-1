package factory.game;

import board.Board;
import display.GameDisplay;
import factory.DisplaysFactory;
import factory.PlaybackModeFactory;
import factory.board.BoardFactory;
import factory.cell.*;
import factory.rules.RulesFactory;
import playbackMode.GameController;
import rule.Rule;

import java.util.List;

public class GameCreator {
    public static GameController getGame(String variant, String playbackMode, String displays, int rows, int cols, String initialBoardPositions) {
        List<Rule> rules = new RulesFactory().factory(variant);
        List<GameDisplay> gameDisplaysList = DisplaysFactory.factory(displays);
        Board board = getBoard(variant, rules, rows, cols, initialBoardPositions);
        return new PlaybackModeFactory().getPlaybackMode(playbackMode, board, gameDisplaysList);
    }


    private static Board getBoard(String variant, List<Rule> rules, int rows, int cols, String initialBoardPositions) {
        return switch (variant) {
            case "classic" ->
                    new BoardFactory().factory(rows, cols, initialBoardPositions, rules, new CellFactory());
            case "immigration" ->
                    new BoardFactory().factory(rows, cols, initialBoardPositions, rules, new CellFactory());
            case "starWars" ->
                    new BoardFactory().factory(rows, cols, initialBoardPositions, rules, new StarWarCellFactory());
            case "briansBrain" ->
                    new BoardFactory().factory(rows, cols, initialBoardPositions, rules, new BriansBrainCellFactory());
            case "quadlife" ->
                    new BoardFactory().factory(rows, cols, initialBoardPositions, rules, new QuadlifeCellFactory());
            default -> throw new IllegalArgumentException("Invalid variant");
        };
    }
}
