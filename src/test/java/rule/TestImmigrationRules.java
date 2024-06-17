package rule;
import board.*;
import cell.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.immigration.RuleBornImmigration;
import rule.immigration.RuleDeadImmigration;
import rule.immigration.RuleStayAliveImmigration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestImmigrationRules {

    private Board board;

    @BeforeEach
    void setup() {
        board = mock(Board.class);
    }

    @Test
    void testRuleBorn() {
        RuleBornImmigration rule = new RuleBornImmigration();
        assertThrows(IllegalStateException.class, rule::apply, "Apply before isApplicable should throw");

        ICell deadCell = new Cell(CellType.DEAD);

        when(board.getCell(0, 0)).thenReturn(deadCell);

        // Scenario: Born Red
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2, 1)); // 2 red, 1 blue
        assertTrue(rule.isApplicable(board, 0, 0));
        assertEquals(CellType.RED, rule.apply().type());

        // Scenario: Born Blue
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(1, 2)); // 1 red, 2 blue
        assertTrue(rule.isApplicable(board, 0, 0));
        assertEquals(CellType.BLUE, rule.apply().type());

        // Scenario: Not Born
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2, 0)); // 2 red, 0 blue
        assertFalse(rule.isApplicable(board, 0, 0));
    }

    @Test
    void testRuleDead() {
        RuleDeadImmigration rule = new RuleDeadImmigration();

        ICell aliveCell = new Cell(CellType.ALIVE);
        ICell deadCell = new Cell(CellType.DEAD);

        // Scenario: Alive cell dies (underpopulation or overpopulation)
        when(board.getCell(0, 0)).thenReturn(aliveCell);
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(1, 0)); // 1 red, 0 blue
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(4, 0)); // 4 red, 0 blue
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2, 0)); // 2 red, 0 blue
        assertFalse(rule.isApplicable(board, 0, 0));

        // Scenario: Dead cell stays dead (not 3 neighbors)
        when(board.getCell(0, 0)).thenReturn(deadCell);
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2, 0)); // 2 red, 0 blue
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(1, 2)); // 1 red, 2 blue
        assertFalse(rule.isApplicable(board, 0, 0));
    }

    @Test
    void testRuleStayAlive() {
        RuleStayAliveImmigration rule = new RuleStayAliveImmigration();
        assertThrows(IllegalStateException.class, rule::apply, "Apply before isApplicable should throw");

        ICell deadCell = new Cell(CellType.DEAD);
        ICell liveCell = new Cell(CellType.ALIVE);
        when(board.getCell(0,0)).thenReturn(deadCell);
        when(board.countNeighboursTypes(0,0)).thenReturn(createNeighborsMap(2,1));// 2 red, 1 blue
        assertTrue(rule.isApplicable(board,0,0));
        assertEquals(CellType.ALIVE, rule.apply().type());

        when(board.getCell(0,0)).thenReturn(liveCell);
        assertFalse(rule.isApplicable(board,0,0));
    }


    private Map<CellType, Integer> createNeighborsMap(int redNeighbors, int blueNeighbors) {
        Map<CellType, Integer> neighbors = new HashMap<>();
        neighbors.put(CellType.RED, redNeighbors);
        neighbors.put(CellType.BLUE, blueNeighbors);
        return neighbors;
    }
}
