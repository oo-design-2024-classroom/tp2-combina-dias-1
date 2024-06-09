package rule.starwars;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.StarWarsCell;

import java.util.List;

public class RuleState3 extends StarWarsRule{
    @Override
    public Cell apply() {
        return new StarWarsCell(CellType.STATE2);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        StarWarsCell cell = (StarWarsCell) board.getCell(row, column);
        return cell.isState2();
    }
}