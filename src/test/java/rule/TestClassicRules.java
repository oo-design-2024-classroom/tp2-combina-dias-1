package rule;

import board.Board;
import factory.board.BoardFactory;
import factory.cell.CellFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassicRules {
    Board board;
    List<Rule> rules;
    BoardFactory factory;

    @BeforeEach
    public void setUp(){
        factory = new BoardFactory();
        rules = new ArrayList<>();
        rules.add(new rule.classic.RuleAliveClassic());
        rules.add(new rule.classic.RuleDeadClassic());
    }

    @Test
    public void testRules(){
        String firstFrame = "XXXXX" +
                          "\nXXXXX" +
                          "\nXOOOX" +
                          "\nXXXXX" +
                          "\nXXXXX";
        board = factory.factory(5,5,firstFrame,rules,new CellFactory());
        String secondFrame = "XXXXX" +
                "\nXXOXX" +
                "\nXXOXX" +
                "\nXXOXX" +
                "\nXXXXX";
        board = board.nextGeneration();
        assertEquals(secondFrame, board.toString());
    }
}
