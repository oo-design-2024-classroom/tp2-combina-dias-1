package rule.starwars;

import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;
import rule.Rule;

import java.util.List;
import java.util.Map;

public class RuleState1 implements Rule {
    ICell cell;
    public ICell apply() {
        if(cell == null)
            throw new IllegalArgumentException("Illegal call");
        return cell;
    }

    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        if(cell.type() != CellType.DEAD)
            return false;
        Map<CellType, Integer> neighbours = board.countNeighboursTypes(row, column);
        return neighbours.get(CellType.ALIVE) == 2;
    }
}
