package rule.starwars;

import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;

import java.util.List;

public class RuleState2 extends StarWarsRule{
    @Override
    public ICell apply() {
        return new Cell(CellType.STATE2);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = (Cell) board.getCell(row, column);
        List<ICell> neighbours = board.getAllNeighbors(row, column);
        int state1Neighbours = countState1Neighbours(neighbours);
        return cell.isState1() && (state1Neighbours < 2 || state1Neighbours > 5);
    }
}