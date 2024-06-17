package rule.classic;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

public class RuleDeadClassic implements Rule {
    @Override
    public ICell apply() {
        return new Cell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(CellType.ALIVE);
        return cell.type() == CellType.ALIVE && (aliveNeighbours < 2 || aliveNeighbours > 3);
    }
}