package rule;

import cell.ClassicCell;
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
        RuleDieUnderpopulationClassic rule = new RuleDieUnderpopulationClassic(neighboursToCheck);
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        assertTrue(rule.isTrue(classicCell, 1));
        assertFalse(rule.isTrue(classicCell, 2));
        assertFalse(rule.isTrue(classicCell, 3));
    }

    @Test
    public void testRuleStayAlive(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(2);
        neighboursToCheck.add(3);
        Rule rule = new RuleStayAliveClassic(neighboursToCheck);
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        assertFalse(rule.isTrue(classicCell, 1));
        assertTrue(rule.isTrue(classicCell, 2));
        assertTrue(rule.isTrue(classicCell, 3));
    }

    @Test
    public void testRuleDieOverPopulation(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(3);
        Rule rule = new RuleDieOverpopulationClassic(neighboursToCheck);
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        for(int i = 0; i<=8;i++){
            if(i<4){
                assertFalse(rule.isTrue(classicCell, i));
            } else {
                assertTrue(rule.isTrue(classicCell, i));
            }
        }
    }

    @Test
    public void testRuleDieUnderPopulation(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(2);
        Rule rule = new RuleDieUnderpopulationClassic(neighboursToCheck);
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        for(int i = 0; i<=8;i++){
            if(i<2){
                assertTrue(rule.isTrue(classicCell, i));
            } else {
                assertFalse(rule.isTrue(classicCell, i));
            }
        }
    }

}
