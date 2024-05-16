package rule;

import cell.Cell;
import cell.CellType;

public class RuleDieUnderpopulation extends Rule {
    public boolean isTrue(Cell cell, int neighbours) {
        return neighbours < 2;
    }
    public Cell execute() {
        return new Cell(CellType.DEAD);
    }
}
