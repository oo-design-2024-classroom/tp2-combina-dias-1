package rule.briansBrain;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import static cell.CellType.ALIVE;

public class RuleDeadBB implements Rule {
    @Override
    public ICell apply() {
        return new Cell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row,column);
        return cell.type() != ALIVE && cell.type() != CellType.ALMOST_DEAD;
    }
}