package rule.immigration;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

public class RuleBorn implements Rule {
    ICell cell;
    @Override
    public ICell apply() {
        if (cell == null) {throw new IllegalStateException("Rule not applied");};
        return cell;
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        ICell cell = board.getCell(row, column);
        if (cell.type() != CellType.DEAD)
            return false;
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int redNeighbours = neighbours.get(CellType.RED);
        int blueNeighbours = neighbours.get(CellType.BLUE);
        int liveNeighbours = redNeighbours + blueNeighbours;
        if (liveNeighbours == 3) {
            if (blueNeighbours >= 2) {
                this.cell = new Cell(CellType.BLUE);
            } else {
                this.cell = new Cell(CellType.RED);
            }
            return true;
        }
        return false;
    }
}
