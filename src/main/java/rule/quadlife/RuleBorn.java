package rule.quadlife;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.ImmigrationCell;

public class RuleBorn extends QuadlifeRule {
    Cell cell;
    @Override
    public Cell apply() {
        if (cell == null) throw new IllegalStateException("Rule not checked if applicable before applying it.");
        return cell;
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        int aliveNeighbours = countAliveNeighbours(board.getAllNeighbors(row, column));
        if (!cell.isAlive() && aliveNeighbours != 3) {
            CellType colorMax = colorMajority(board.getAllNeighbors(row, column));
            cell = new ImmigrationCell(colorMax);
            return true;
        }
        return false;
    }
}