package factory;

import board.*;
import org.junit.jupiter.api.Test;
import rule.Rule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestBoardFactory {
    BoardFactory boardFactory = new BoardFactory();
    CellFactory cellFactory = new CellFactory();
    RulesFactory rulesFactory = new RulesFactory();
    String boardString = "XXX\nOOO\nXXX";
    @Test
    public void testCreateBoard() {
        List<Rule> rules = rulesFactory.factory("classic");
        IBoard board = boardFactory.factory(3,3,boardString, rules, cellFactory);
        assertEquals(boardString, board.toString());
    }
    @Test
    public void testInvalidDimensions() {
        List<Rule> rules = rulesFactory.factory("classic");
        assertThrows(IllegalArgumentException.class, () -> boardFactory.factory(2,3,boardString, rules, cellFactory));
    }
}
