package rule.quadlife;

import board.Board;
import cell.CellType;
import cell.ICell;
import rule.Rule;

import java.util.Map;

public class RuleStayAliveQuadlife implements Rule {
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
        return cell.type() != CellType.DEAD && (aliveNeighbours == 2 || aliveNeighbours == 3);
    }
}
