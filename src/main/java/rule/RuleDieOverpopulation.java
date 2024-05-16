package rule;

import cell.Cell;
import cell.CellType;

public class RuleDieOverpopulation extends Rule {
    public boolean isTrue(Cell cell, int neighbours) {
        return neighbours > 3;
    }
    public Cell execute() {
        return new Cell(CellType.DEAD);
    }
}

