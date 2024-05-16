package rule;

import cell.Cell;
import cell.CellType;

public class RuleStayAlive extends Rule{
    public boolean isTrue(Cell cell, int neighbours) {
        return cell.isAlive() && (neighbours == 2 || neighbours == 3);
    }
    public Cell execute() {
        return new Cell(CellType.ALIVE);
    }
}
