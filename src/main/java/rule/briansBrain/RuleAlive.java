package rule.briansBrain;

import board.Board;
import cell.BriansBrainCell;
import cell.Cell;
import cell.CellType;

import java.util.List;

public class RuleAlive extends BBRule {
    @Override
    public Cell apply() {
        return new BriansBrainCell(CellType.ALIVE);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = board.getCell(row,column);
        List<Cell> neighbours = board.getAllNeighbors(row,column);
        int aliveNeighbours = countAliveNeighbours(neighbours);
        return !cell.isAlive() && aliveNeighbours == 2;
    }
}