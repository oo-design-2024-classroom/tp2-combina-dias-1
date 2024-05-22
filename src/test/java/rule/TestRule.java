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

}
