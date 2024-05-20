package rule;

import cell.Cell;
import cell.CellType;

import java.util.List;

public class RuleStayAlive extends Rule {
    public RuleStayAlive(List<Integer> neighboursToCheck) {
        super(neighboursToCheck);
        if(neighboursToCheck.size() != 2)
            throw new IllegalArgumentException("neighboursToCheck.size() != 2");
    }
    public boolean isTrue(Cell cell, int neighbours) {
        return cell.isAlive() && (neighbours == neighboursToCheck.get(0) || neighbours == neighboursToCheck.get(1));
    }
    public Cell execute() {
        return new Cell(CellType.ALIVE);
    }
}
