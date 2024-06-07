package rule;

import cell.ClassicCell;
import cell.CellType;
import org.junit.jupiter.api.Test;
import rule.classic.*;
import rule.classic.ClassicRule;
import rule.classic.ClassicRuleDieOverpopulationClassic;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestImmigration {
    @Test
    public void testRuleDieUnderpopulation() {
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(2);
        ClassicRuleDieUnderpopulationClassic rule = new ClassicRuleDieUnderpopulationClassic(neighboursToCheck);
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
        ClassicRule classicRule = new ClassicRuleStayAliveClassic(neighboursToCheck);
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        assertFalse(classicRule.isTrue(classicCell, 1));
        assertTrue(classicRule.isTrue(classicCell, 2));
        assertTrue(classicRule.isTrue(classicCell, 3));
    }

    @Test
    public void testRuleDieOverPopulation(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(3);
        ClassicRule classicRule = new ClassicRuleDieOverpopulationClassic(neighboursToCheck);
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        for(int i = 0; i<=8;i++){
            if(i<4){
                assertFalse(classicRule.isTrue(classicCell, i));
            } else {
                assertTrue(classicRule.isTrue(classicCell, i));
            }
        }
    }

    @Test
    public void testRuleDieUnderPopulation(){
        ArrayList<Integer> neighboursToCheck = new ArrayList<>();
        neighboursToCheck.add(2);
        ClassicRule classicRule = new ClassicRuleDieUnderpopulationClassic(neighboursToCheck);
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        for(int i = 0; i<=8;i++){
            if(i<2){
                assertTrue(classicRule.isTrue(classicCell, i));
            } else {
                assertFalse(classicRule.isTrue(classicCell, i));
            }
        }
    }

}
