package cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import board.Board;
import rule.briansBrain.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestBriansBrainRules {

    private Board board;

    @BeforeEach
    void setup() {
        board = mock(Board.class);
    }

    @Test
    void testRuleSemiDead() {
        RuleSemiDead rule = new RuleSemiDead();
        ICell aliveCell = new Cell(CellType.ALIVE);

        when(board.getCell(0, 0)).thenReturn(aliveCell);
        assertTrue(rule.isApplicable(board, 0, 0));

        ICell deadCell = new Cell(CellType.DEAD);
        when(board.getCell(0, 0)).thenReturn(deadCell);
        assertFalse(rule.isApplicable(board, 0, 0));

        ICell result = rule.apply();
        assertEquals(CellType.ALMOST_DEAD, result.type());
    }

    @Test
    void testRuleDead() {
        RuleDead rule = new RuleDead();
        ICell deadCell = new Cell(CellType.DEAD);
        ICell almostDeadCell = new Cell(CellType.ALMOST_DEAD);
        ICell aliveCell = new Cell(CellType.ALIVE);

        // Alive and almost dead cell scenarios
        when(board.getCell(0, 0)).thenReturn(aliveCell);
        assertFalse(rule.isApplicable(board, 0, 0));

        when(board.getCell(0, 0)).thenReturn(almostDeadCell);
        assertFalse(rule.isApplicable(board, 0, 0));

        // Dead cell scenario
        when(board.getCell(0, 0)).thenReturn(deadCell);
        assertTrue(rule.isApplicable(board, 0, 0));

        ICell result = rule.apply();
        assertEquals(CellType.DEAD, result.type());
    }

    @Test
    void testRuleAlive() {
        RuleAlive rule = new RuleAlive();
        ICell deadCell = new Cell(CellType.DEAD);

        when(board.getCell(0, 0)).thenReturn(deadCell);

        // Scenario: Born Alive (2 alive neighbors)
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2, 0)); // 2 alive, 0 almost dead
        assertTrue(rule.isApplicable(board, 0, 0));

        // Scenario: Born Alive (3 alive and 1 almost dead neighbors)
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(3, 1));
        assertTrue(rule.isApplicable(board, 0, 0));

        // Scenario: Not Born Alive (1 alive neighbors)
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(1, 0));
        assertFalse(rule.isApplicable(board, 0, 0));

        // Scenario: Not Born Alive (other cell type)
        ICell aliveCell = new Cell(CellType.ALIVE);
        when(board.getCell(0, 0)).thenReturn(aliveCell);
        when(board.countNeighboursTypes(0, 0)).thenReturn(createNeighborsMap(2, 0));
        assertFalse(rule.isApplicable(board, 0, 0));

        ICell result = rule.apply();
        assertEquals(CellType.ALIVE, result.type());
    }


    private Map<CellType, Integer> createNeighborsMap(int aliveNeighbors, int almostDeadNeighbors) {
        Map<CellType, Integer> neighbors = new HashMap<>();
        neighbors.put(CellType.ALIVE, aliveNeighbors);
        neighbors.put(CellType.ALMOST_DEAD, almostDeadNeighbors);
        return neighbors;
    }
}
