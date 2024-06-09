package rule.immigration;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.ImmigrationCell;

public class RuleBornBlue extends RuleImmigration{
    @Override
    public Cell apply() {
        return new ImmigrationCell(CellType.BLUE);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = board.getCell(row, column);
        if (cell.getCellType() == CellType.DEAD) {
            int redNeighbours = countRedCells(board.getAllNeighbors(row, column));
            int blueNeighbours = countBlueCells(board.getAllNeighbors(row, column));
            int liveNeighbours = redNeighbours + blueNeighbours;
            return liveNeighbours==3 && blueNeighbours >= 2;
        }
        return false;
    }
}
