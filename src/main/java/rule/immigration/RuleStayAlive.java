package rule.immigration;

import board.Board;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

public class RuleStayAlive implements Rule {
    ICell cell;
    @Override
    public ICell apply() {
        if (cell == null)
            throw new IllegalStateException("Rule not checked if applicable before applying it.");
        return cell;
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        if (cell.type() == CellType.DEAD) {
            Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
            int aliveNeighbours = neighbours.get(CellType.RED) + neighbours.get(CellType.BLUE);
            return aliveNeighbours == 2 || aliveNeighbours == 3;
        }
        return false;
    }
}
