package rule.starwars;

import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;
import rule.Rule;

import java.util.List;
import java.util.Map;

public class RuleState2 implements Rule {
    public ICell apply() {
        return new Cell(CellType.STATE2);
    }

    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        Map<CellType, Integer> neighbours = board.countNeighboursTypes(row, column);
        int liveCells = neighbours.get(CellType.ALIVE);
        if(cell.type() == CellType.ALIVE && (liveCells < 3 || liveCells > 5)) return true;
        return false;
    }
}