package rule;

import board.Board;
import cell.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.classic.RuleAliveClassic;
import rule.classic.RuleDeadClassic;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestClassicRules {

    private Board board;

    @BeforeEach
    void setup() {
        board = mock(Board.class);
    }

    @Test
    void testRuleAliveClassic() {
        RuleAliveClassic rule = new RuleAliveClassic();
        ICell result = rule.apply();
        assertEquals(CellType.ALIVE, result.type());

        testIsApplicableAlive(rule);
    }

    @Test
    void testRuleDeadClassic() {
        RuleDeadClassic rule = new RuleDeadClassic();
        ICell result = rule.apply();
        assertEquals(CellType.DEAD, result.type());

    }

    private void testIsApplicableAlive(Rule rule) {
        ICell aliveCell = new Cell(CellType.ALIVE);
        ICell deadCell = new Cell(CellType.DEAD);

        // Alive cell scenarios
        when(board.getCell(0, 0)).thenReturn(aliveCell);
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2));
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(3));
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(1)); // 1 alive neighbor
        assertFalse(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(4)); // 4 alive neighbors
        assertFalse(rule.isApplicable(board, 0, 0));

        // Dead cell scenarios
        when(board.getCell(0, 0)).thenReturn(deadCell);
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(3)); // 3 alive neighbors
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2)); // 2 alive neighbors
        assertFalse(rule.isApplicable(board, 0, 0));
    }

    private void testIsApplicableDead(Rule rule) {
        ICell aliveCell = new Cell(CellType.ALIVE);

        when(board.getCell(0, 0)).thenReturn(aliveCell);
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(1)); // 1 alive neighbor
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(4)); // 4 alive neighbors
        assertTrue(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2)); // 2 alive neighbors
        assertFalse(rule.isApplicable(board, 0, 0));

        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(3)); // 3 alive neighbors
        assertFalse(rule.isApplicable(board, 0, 0));
    }

    private Map<CellType, Integer> createNeighborsMap(int aliveNeighbors) {
        Map<CellType, Integer> neighbors = new HashMap<>();
        neighbors.put(CellType.ALIVE, aliveNeighbors);
        return neighbors;
    }
}
