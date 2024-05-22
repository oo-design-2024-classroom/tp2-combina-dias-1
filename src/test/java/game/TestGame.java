package game;

import board.Board;
import factory.BoardFactory;
import factory.RulesFactory;
import observer.ConsoleOutput;
import org.junit.jupiter.api.Test;
import rule.*;
import java.util.List;


public class TestGame {
    @Test
    public void testThreeTurns() throws InterruptedException {
        RulesFactory rulesFactory = new RulesFactory();
        List<Rule> rules = rulesFactory.factory("B3/S23");
        BoardFactory boardFactory = new BoardFactory();
        String boardStr = "XOX\nXOX\nXOX";
        Board board = boardFactory.factory(3,3,boardStr, rules);
        Game game = new Game(board);
        ConsoleOutput output = new ConsoleOutput();
        game.addObserver(output);
        game.play(3);
    }
}
