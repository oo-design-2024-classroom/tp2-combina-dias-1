package rule.briansBrain;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

public class RuleAlive implements Rule {
    @Override
    public ICell apply() {
        return new Cell(CellType.ALIVE);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row,column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(CellType.ALIVE);
        int almostDeadNeighbours = neighbours.get(CellType.ALMOST_DEAD);
        if(cell.type() != CellType.DEAD)
            return false;
        return aliveNeighbours == 2 || (almostDeadNeighbours == 1 && aliveNeighbours == 3);
    }
}