package rule.immigration;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

public class RuleDeadImmigration implements Rule {
    ICell cell;
    @Override
    public ICell apply() {
        return new Cell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(CellType.RED) + neighbours.get(CellType.BLUE);
        if (cell.type() == CellType.DEAD && aliveNeighbours != 3)
            return true;
        return cell.type() != CellType.DEAD && aliveNeighbours < 2 || aliveNeighbours > 3;
    }
}
