package rule.briansBrain;

import board.Board;
import cell.BriansBrainCell;
import cell.Cell;
import cell.CellType;

public class RuleDead extends BBRule {
    @Override
    public Cell apply() {
        return new BriansBrainCell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = board.getCell(row,column);
        return !cell.isAlive();
    }
}