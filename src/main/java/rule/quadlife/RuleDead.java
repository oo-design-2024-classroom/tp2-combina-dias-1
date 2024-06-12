package rule.quadlife;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;

import java.util.Map;

public class RuleDead extends QuadlifeRule {
    @Override
    public ICell apply() {
        return new Cell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(CellType.RED) + neighbours.get(CellType.GREEN) + neighbours.get(CellType.BLUE) + neighbours.get(CellType.YELLOW);
        if (cell.type() == CellType.DEAD && aliveNeighbours != 3) return true;
        if (cell.type() != CellType.DEAD && (aliveNeighbours < 2 || aliveNeighbours > 3)) return true;
        return false;
    }
}
