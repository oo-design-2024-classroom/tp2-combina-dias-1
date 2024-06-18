package rule.starwars;

import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;
import rule.Rule;

import java.util.List;
import java.util.Map;

public class RuleState1 implements Rule {
    public ICell apply() {
        return new Cell(CellType.ALIVE);
    }

    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        Map<CellType, Integer> neighbours = board.countNeighboursTypes(row, column);
        int aliveN = neighbours.get(CellType.ALIVE);
        if (cell.type()==CellType.ALIVE && aliveN >=3 && aliveN <= 5) {
            return true;
        }
        if (cell.type()==CellType.DEAD && aliveN == 2) {
            return true;
        }
        return false;
    }
}
