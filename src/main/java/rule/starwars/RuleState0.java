package rule.starwars;
import board.Board;
import cell.*;
import rule.Rule;

import java.util.Map;

public class RuleState0 implements Rule {
    ICell cell;
    public ICell apply() {
        if(cell == null)
            throw new IllegalArgumentException("Illegal call");
        return cell;
    }

    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        if(cell.type() == CellType.STATE2) {
            cell = new Cell(CellType.ALMOST_DEAD);
            return true;
        }
        if(cell.type() == CellType.ALMOST_DEAD) {
            cell = new Cell(CellType.DEAD);
            return true;
        }
        return false;
    }
}