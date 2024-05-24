package rule;

import cell.Cell;
import cell.CellType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRule {
    @Test
    public void testRuleDieUnderpopulation() {
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(2);
        RuleDieUnderpopulation rule = new RuleDieUnderpopulation(neighboursToCheck);
        Cell cell = new Cell(CellType.ALIVE);
        assertTrue(rule.isTrue(cell, 1));
        assertFalse(rule.isTrue(cell, 2));
        assertFalse(rule.isTrue(cell, 3));
    }

    @Test
    public void testRuleStayAlive(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(2);
        neighboursToCheck.add(3);
        Rule rule = new RuleStayAlive(neighboursToCheck);
        Cell cell = new Cell(CellType.ALIVE);
        assertFalse(rule.isTrue(cell, 1));
        assertTrue(rule.isTrue(cell, 2));
        assertTrue(rule.isTrue(cell, 3));
    }

    @Test
    public void testRuleDieOverPopulation(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(3);
        Rule rule = new RuleDieOverpopulation(neighboursToCheck);
        Cell cell = new Cell(CellType.ALIVE);
        for(int i = 0; i<=8;i++){
            if(i<4){
                assertFalse(rule.isTrue(cell, i));
            } else {
                assertTrue(rule.isTrue(cell, i));
            }
        }
    }

    @Test
    public void testRuleDieUnderPopulation(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(2);
        Rule rule = new RuleDieUnderpopulation(neighboursToCheck);
        Cell cell = new Cell(CellType.ALIVE);
        for(int i = 0; i<=8;i++){
            if(i<2){
                assertTrue(rule.isTrue(cell, i));
            } else {
                assertFalse(rule.isTrue(cell, i));
            }
        }
    }

}
