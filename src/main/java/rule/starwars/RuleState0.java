package rule.starwars;
import board.Board;
import cell.*;
import rule.Rule;

import java.util.Map;

import static cell.CellType.DEAD;

public class RuleState0 implements Rule {
    public ICell apply() {
        return new Cell(DEAD);
    }

    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        if(cell.type() == CellType.STATE3) {
            return true;
        }
        int liveNeighbours = board.countNeighboursTypes(row, column).get(CellType.ALIVE);
        return cell.type() == CellType.DEAD && liveNeighbours != 2;
    }
}