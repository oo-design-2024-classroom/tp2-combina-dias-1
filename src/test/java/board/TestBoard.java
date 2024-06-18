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
    @Test
    public void testBBBoardNextGeneration(){
        String firstFrame = "X3XX" +
                "\nXOO3" +
                "\n3OOX"+
                "\nXX3X";
        rules = rulesFactory.factory("briansBrain");
        board = boardFactory.factory(4,4,firstFrame,rules, cellFactory);
        board = board.nextGeneration();
        System.out.println(board.toString());
    }
    @Test
    public void testImmigrationBoardNextGeneration(){
        String firstFrame = "XXXXX" +
                "\nXRRRX" +
                "\nXXXXX"+
                "\nXXXXX"+
                "\nXXXXX";
        String frame = "XXXXX" +
                "\nXRRRX" +
                "\nXXXXX"+
                "\nXXXXX"+
                "\nXXXXX";
        rules = rulesFactory.factory("immigration");
        board = boardFactory.factory(5,5,firstFrame,rules, cellFactory);
        board = board.nextGeneration();
        board = board.nextGeneration();
        board = board.nextGeneration();
        assertEquals(frame, board.toString());
    }
    @Test
    public void testQuadlifeBoardNextGeneration(){
        String firstFrame = "XXXXXXXXX\n" +
                "XXRXGXRXX\n" +
                "XXXRGRXXX\n" +
                "XXGRGRGXX\n" +
                "XXXRGRXXX\n" +
                "XXRXGXRXX\n" +
                "XXXXXXXXX";
        rules = rulesFactory.factory("quadlife");
        board = boardFactory.factory(7,9,firstFrame,rules, cellFactory);
        board = board.nextGeneration();
        board = board.nextGeneration();
        board = board.nextGeneration();
        assertEquals(firstFrame, board.toString());
    }
    @Test
    public void testStarWarsNextGeneration(){
        String firstFrame = "XOX\nOOO\nXOX";
        rules = rulesFactory.factory("starWars");
        board = boardFactory.factory(7,9,firstFrame,rules, cellFactory);
        board = board.nextGeneration();
        assertEquals(firstFrame, board.toString());
    }

}