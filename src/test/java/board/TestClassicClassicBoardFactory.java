package board;

import factory.board.ClassicBoardFactory;
import factory.rules.ClassicRulesFactory;
import org.junit.jupiter.api.Test;
import rule.classic.ClassicRule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClassicClassicBoardFactory {
    @Test
    public void testBoardFactory(){
        ClassicBoardFactory factory = new ClassicBoardFactory();
        ClassicRulesFactory classicRulesFactory = new ClassicRulesFactory();
        List<ClassicRule> classicRules = classicRulesFactory.factory("B3/S23");
        Board board = factory.factory(2,2,"XX\nXO", classicRules);
        assertTrue(board.getCell(1,1).isAlive());
        assertFalse(board.getCell(0,0).isAlive());
    }
}
