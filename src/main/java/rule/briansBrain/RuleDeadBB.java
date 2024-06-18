package rule.briansBrain;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

import static cell.CellType.ALIVE;
import static cell.CellType.DEAD;

public class RuleDeadBB implements Rule {
    @Override
    public ICell apply() {
        return new Cell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row,column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row, column);
        int liveCells = neighbours.get(ALIVE);
        if (cell.type() == DEAD && liveCells != 2)
            return true;
        return cell.type() == CellType.STATE2;
    }
}