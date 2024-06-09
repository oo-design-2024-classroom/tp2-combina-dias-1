package rule.quadlife;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.ImmigrationCell;

public class RuleDead extends QuadlifeRule {
    @Override
    public Cell apply() {
        return new ImmigrationCell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = board.getCell(row, column);
        int aliveNeighbours = countAliveNeighbours(board.getAllNeighbors(row, column));
        if (!cell.isAlive() && aliveNeighbours != 3) return true;
        if (cell.isAlive() && (aliveNeighbours < 2 || aliveNeighbours > 3)) return true;
        return false;
    }
}
