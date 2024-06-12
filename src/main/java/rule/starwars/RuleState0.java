package rule.starwars;
import board.Board;
import cell.ICell;
import cell.CellType;
import cell.Cell;
import java.util.List;
import java.util.Map;

public class RuleState0 extends StarWarsRule{
    @Override
    public ICell apply() {
        return new Cell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = (Cell) board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int state1Neighbours = neighbours.get(CellType.ALIVE);
        if (cell.type() == CellType.DEAD && state1Neighbours != 2) return true;
        if (cell.type() == CellType.ALMOST_DEAD) return true;
        return false;
    }
}