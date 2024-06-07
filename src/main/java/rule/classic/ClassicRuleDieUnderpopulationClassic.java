package rule.classic;

import cell.Cell;
import cell.ClassicCell;
import cell.CellType;

import java.util.List;

public class ClassicRuleDieUnderpopulationClassic extends ClassicRule {
    public ClassicRuleDieUnderpopulationClassic(List<Integer> neighboursToCheck) {
        super(neighboursToCheck);
        if(neighboursToCheck.size() != 1)
            throw new IllegalArgumentException("Illegal number of neighbours to check");
    }
    public boolean isTrue(Cell classicCell, int neighbours) {
        return neighbours < neighboursToCheck.get(0);
    }
    public Cell execute() {
        return new ClassicCell(CellType.DEAD);
    }
}
