package rule.starwars;

import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;

import java.util.List;

public class RuleState1 extends StarWarsRule{
    @Override
    public ICell apply() {
        return new Cell(CellType.ALIVE);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = (Cell) board.getCell(row, column);
        List<ICell> neighbours = board.getAllNeighbors(row, column);
        int state1Neighbours = countState1Neighbours(neighbours);
        if (cell.isState0() && state1Neighbours == 2) return true;
        if (cell.isState1() && state1Neighbours >= 3 && state1Neighbours <= 5) return true;
        return false;
    }
}
