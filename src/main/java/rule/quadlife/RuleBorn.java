package rule.quadlife;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;

import java.util.Map;

public class RuleBorn extends QuadlifeRule {
    ICell cell;
    @Override
    public ICell apply() {
        if (cell == null) throw new IllegalStateException("Rule not checked if applicable before applying it.");
        return cell;
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(CellType.RED) + neighbours.get(CellType.GREEN) + neighbours.get(CellType.BLUE) + neighbours.get(CellType.YELLOW);
        if (cell.type() != CellType.DEAD && aliveNeighbours != 3) {
            CellType colorMax = colorMajority(neighbours);
            cell = new Cell(colorMax);
            return true;
        }
        return false;
    }
}