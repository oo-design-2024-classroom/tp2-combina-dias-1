package factory.game;

import board.Board;
import display.GameDisplay;
import factory.DisplaysFactory;
import factory.PlaybackModeFactory;
import factory.board.ClassicBoardFactory;
import factory.rules.RulesFactory;
import playbackMode.GameController;
import rule.Rule;

import java.util.List;

public class BriansBrainGameFactory implements GameVariantFactory {
    @Override
    public GameController createController(String playbackMode, String displays, int rows, int cols, String initialBoardPositions) {
        List<Rule> rules = new RulesFactory().factory("classic");
        Board board = new ClassicBoardFactory().factory(rows, cols, initialBoardPositions, rules);
        List<GameDisplay> gameDisplaysList = DisplaysFactory.factory(displays);
        return new PlaybackModeFactory().getPlaybackMode(playbackMode, board, gameDisplaysList);
    }
}