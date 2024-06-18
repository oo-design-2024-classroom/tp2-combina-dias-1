package board;

import factory.*;
import rule.Rule;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;


public class TestBoard {
    IBoard board;
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
    public void testBBBoardOscillator(){
        String firstFrame = """
                XXXXXX
                XX2XXX
                XXOO2X
                X2OOXX
                XXX2XX
                XXXXXX""";
        String secondFrame = """
                XXXXXX
                XXXOXX
                XO22XX
                XX22OX
                XXOXXX
                XXXXXX""";
        String thirdFrame = """
                XXXXXX
                XXO2XX
                X2XXOX
                XOXX2X
                XX2OXX
                XXXXXX""";
        rules = rulesFactory.factory("briansBrain");
        board = boardFactory.factory(6,6,firstFrame,rules, cellFactory);
        String[] frameOrder = {secondFrame, thirdFrame, firstFrame};
        for(String frame: frameOrder){
            board = board.nextGeneration();
            assertEquals(frame, board.toString());
        }
    }
    @Test
    public void testImmigrationBoardRedAndBlueBlinker(){
        String firstFrame = """
                XXX
                RBR
                XXX""";
        String secondFrame = """
                XRX
                XBX
                XRX""";
        rules = rulesFactory.factory("immigration");
        board = boardFactory.factory(3,3,firstFrame,rules, cellFactory);
        String[] frameOrder = {firstFrame, secondFrame, firstFrame};
        for(String frame: frameOrder){
            assertEquals(frame, board.toString());
            board = board.nextGeneration();
        }
    }
    @Test
    public void testQuadlifeBoardToadOscillator(){
        String firstFrame = """
                XXRX
                RXXR
                RXXR
                XRXX""";
        String secondFrame = """
                XXXX
                XRRR
                RRRX
                XXXX""";
        rules = rulesFactory.factory("quadlife");
        board = boardFactory.factory(4,4,firstFrame,rules, cellFactory);
        String[] frameOrder = {firstFrame, secondFrame, firstFrame};
        for(String frame: frameOrder){
            assertEquals(frame, board.toString());
            board = board.nextGeneration();
        }
    }
    @Test
    public void testStarWarsStillLife(){
        String firstFrame = "XOX\nOOO\nXOX";
        rules = rulesFactory.factory("starWars");
        board = boardFactory.factory(3,3,firstFrame,rules, cellFactory);
        assertEquals(firstFrame, board.toString());
        board = board.nextGeneration();
        assertEquals(firstFrame, board.toString());
    }
    @Test
    public void testStarWarsOscillator(){
        String firstFrame = """
        XO23X
        XXOXX
        XOOOX
        XXOXX
        XXXXX""";
        String secondFrame = """
        X23XX
        OXOXX
        XOOOX
        XXOXX
        XXXXX""";
        rules = rulesFactory.factory("starWars");
        board = boardFactory.factory(5,5,firstFrame,rules, cellFactory);
        assertEquals(firstFrame, board.toString());
        board = board.nextGeneration();
        assertEquals(secondFrame, board.toString());
    }
    @Test
    public void invalidGeneration() {
        String firstFrame = """
        XO23X
        XXOXX
        XOOOX
        XXOXX
        XXXXX""";
        rules = new ArrayList<>();
        board = boardFactory.factory(5,5,firstFrame,rules, cellFactory);
        assertThrows(IllegalStateException.class, () -> board.nextGeneration());
    }
}