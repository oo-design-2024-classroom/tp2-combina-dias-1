package rule;

import cell.Cell;
import cell.CellType;

import java.util.List;

public class RuleDieUnderpopulation extends Rule {
    public RuleDieUnderpopulation(List<Integer> neighboursToCheck) {
        super(neighboursToCheck);
        if(neighboursToCheck.size() != 1)
            throw new IllegalArgumentException("Illegal number of neighbours to check");
    }
    public boolean isTrue(Cell cell, int neighbours) {
        return neighbours < neighboursToCheck.get(0);
    }
    public Cell execute() {
        return new Cell(CellType.DEAD);
    }
}
