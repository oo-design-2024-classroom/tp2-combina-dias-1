package rule;

import cell.Cell;
import cell.CellType;

import java.util.List;

public class RuleDieOverpopulation extends Rule {
    public RuleDieOverpopulation(List<Integer> neighborsToCheck) {
        super(neighborsToCheck);
        if(neighborsToCheck.size() != 1)
            throw new IllegalArgumentException("Illegal number of neighbors to check");
    }
    public boolean isTrue(Cell cell, int neighbours) {
        return neighbours > neighboursToCheck.get(0);
    }
    public Cell execute() {
        return new Cell(CellType.DEAD);
    }
}

