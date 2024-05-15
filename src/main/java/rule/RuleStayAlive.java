package rule;

import cell.Cell;
import cell.CellType;

public class RuleStayAlive extends Rule{
    @Override
    public Cell apply(int row, int col) {
        Cell cell = board.getCell(row, col);
        if (cell.isAlive() && (board.getNeighbors(row, col) == 2 || board.getNeighbors(row, col) == 3))
            return new Cell(CellType.ALIVE);
        return cell;
    }
}
