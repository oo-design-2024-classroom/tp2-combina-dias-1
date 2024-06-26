package rule.classic;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

public class RuleAliveClassic implements Rule {
    @Override
    public ICell apply() {
        return new Cell(CellType.ALIVE);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(CellType.ALIVE);
        if (cell.type() == CellType.ALIVE && (aliveNeighbours == 2 || aliveNeighbours == 3)) return true;
        return cell.type()== CellType.DEAD && aliveNeighbours == 3;
    }
}