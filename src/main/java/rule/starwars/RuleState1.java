package rule.starwars;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.StarWarsCell;

import java.util.List;

public class RuleState1 extends StarWarsRule{
    @Override
    public Cell apply() {
        return new StarWarsCell(CellType.ALIVE);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        StarWarsCell cell = (StarWarsCell) board.getCell(row, column);
        List<Cell> neighbours = board.getAllNeighbors(row, column);
        int state1Neighbours = countState1Neighbours(neighbours);
        if (cell.isState0() && state1Neighbours == 2) return true;
        if (cell.isState1() && state1Neighbours >= 3 && state1Neighbours <= 5) return true;
        return false;
    }
}
