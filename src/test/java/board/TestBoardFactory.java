package board;

import factory.BoardFactory;
import factory.RulesFactory;
import org.junit.jupiter.api.Test;
import rule.Rule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBoardFactory {
    @Test
    public void testBoardFactory(){
        BoardFactory factory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        List<Rule> rules = rulesFactory.factory("B3/S23");
        IBoard board = factory.factory(2,2,"XX\nXO",rules);
        assertTrue(board.getCell(1,1).isAlive());
        assertFalse(board.getCell(0,0).isAlive());
    }
}
