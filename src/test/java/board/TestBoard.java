package board;

import factory.*;
import rule.Rule;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


public class TestBoard {
    Board board;
    List<Rule> rules;
    BoardFactory boardFactory = new BoardFactory();
    RulesFactory rulesFactory = new RulesFactory();
    CellFactory cellFactory = new CellFactory();

    @Test
    public void testClassicBoardNextGeneration(){
        String firstFrame = "XXX" +
                "\nOOO" +
                "\nXXX";
        rules = rulesFactory.factory("classic");
        board = boardFactory.factory(3,3,firstFrame,rules, cellFactory);
        String secondFrame = "XOX" +
                "\nXOX" +
                "\nXOX";
        board = board.nextGeneration();
        assertEquals(secondFrame, board.toString());
    }
}