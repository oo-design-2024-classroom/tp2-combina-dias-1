package game;

import board.Board;
import factory.BoardFactory;
import factory.RulesFactory;
import observer.ConsoleOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestGame {
    RulesFactory rulesFactory;
    List<Rule> rules;

    @BeforeEach
    public void setUp(){
        rulesFactory = new RulesFactory();
        rules = rulesFactory.factory("B3/S23");
    }
    @Test
    public void testThreeTurns() throws InterruptedException {
        BoardFactory boardFactory = new BoardFactory();
        String boardStr = "XOX\nXOX\nXOX";
        Board board = boardFactory.factory(3,3,boardStr, rules);
        Game game = new Game(board);
        ConsoleOutput output = new ConsoleOutput();
        game.addObserver(output);
        game.play(3);
    }
    @Test
    public void testGameConstructor(){
        Game game = new Game(3,3,rules);
        assertEquals("X X X |\nX X X |\nX X X |", game.getBoard().toString().strip());
    }
}
