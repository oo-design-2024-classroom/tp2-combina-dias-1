package rule.briansBrain;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

public class RuleSemiDead implements Rule {
    @Override
    public ICell apply() {
        return new Cell(CellType.ALMOST_DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row,column);
        return cell.type() == CellType.ALIVE;
    }
}
