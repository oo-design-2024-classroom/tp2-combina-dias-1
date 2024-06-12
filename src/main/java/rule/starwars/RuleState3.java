package rule.starwars;

import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;

public class RuleState3 extends StarWarsRule{
    @Override
    public ICell apply() {
        return new Cell(CellType.STATE2);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = (Cell) board.getCell(row, column);
        return cell.isState2();
    }
}