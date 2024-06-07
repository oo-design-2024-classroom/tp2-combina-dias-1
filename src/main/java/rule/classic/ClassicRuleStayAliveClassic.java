package rule.classic;

import cell.Cell;
import cell.ClassicCell;
import cell.CellType;

import java.util.List;

public class ClassicRuleStayAliveClassic extends ClassicRule {
    public ClassicRuleStayAliveClassic(List<Integer> neighboursToCheck) {
        super(neighboursToCheck);
        if(neighboursToCheck.size() != 2)
            throw new IllegalArgumentException("neighboursToCheck.size() != 2");
    }
    public boolean isTrue(Cell classicCell, int neighbours) {
        return classicCell.isAlive() && (neighbours == neighboursToCheck.get(0) || neighbours == neighboursToCheck.get(1));
    }
    public Cell execute() {
        return new ClassicCell(CellType.ALIVE);
    }
}
