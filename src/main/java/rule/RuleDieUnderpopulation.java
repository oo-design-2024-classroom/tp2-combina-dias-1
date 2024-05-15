package rule;

import cell.Cell;
import cell.CellType;

public class RuleDieUnderpopulation extends Rule {
    public Cell apply(int row, int col) {
        Cell cell = board.getCell(row, col);
        if (board.getNeighbors(row, col) < 2)
            return new Cell(CellType.DEAD);
        return cell;
    }
}
