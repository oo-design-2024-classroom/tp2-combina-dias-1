package rule.starwars;

import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;
import rule.Rule;

import java.util.List;
import java.util.Map;

public class RuleState2 implements Rule {
    ICell cell;
    public ICell apply() {
        if(cell == null)
            throw new IllegalArgumentException("Illegal call");
        return cell;
    }

    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        if(cell.type() != CellType.ALIVE)
            return false;
        Map<CellType, Integer> neighbours = board.countNeighboursTypes(row, column);
        if(neighbours.get(CellType.ALIVE) < 3 || neighbours.get(CellType.ALIVE) > 5)
            cell = new Cell(CellType.STATE2);
        return true;
    }
}