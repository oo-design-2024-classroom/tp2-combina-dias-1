package rule.immigration;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.ImmigrationCell;

import java.util.List;

public class RuleDead extends RuleImmigration{
    Cell cell;
    @Override
    public Cell apply() {
        return new ImmigrationCell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        List<Cell> neighbours = board.getAllNeighbors(row, column);
        int aliveNeighbours = countAliveNeighbours(neighbours);
        if (!cell.isAlive() && aliveNeighbours !=3) return true;
        if (cell.isAlive() && aliveNeighbours <2 || aliveNeighbours >3) return true;
        return false;
    }
}
