package rule.immigration;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.ImmigrationCell;

public class RuleStayAlive extends RuleImmigration{
    Cell cell;
    @Override
    public Cell apply() {
        if (cell == null) throw new IllegalStateException("Rule not checked if applicable before applying it.");
        return cell;
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        if (cell.getCellType() == CellType.DEAD) {
            int liveNeighbours = countAliveNeighbours(board.getAllNeighbors(row, column));
            return liveNeighbours==2 || liveNeighbours==3;
        }
        return false;
    }
}
