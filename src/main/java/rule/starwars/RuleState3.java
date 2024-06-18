package rule.starwars;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.ICell;
import rule.Rule;

import static cell.CellType.DEAD;
import static cell.CellType.STATE3;

public class RuleState3 implements Rule {
    public ICell apply() {
        return new Cell(STATE3);
    }

    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        if(cell.type() == CellType.STATE2) {
            return true;
        } return false;
    }
}