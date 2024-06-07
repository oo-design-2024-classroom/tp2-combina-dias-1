package rule.classic;
import cell.*;

import java.util.List;

public class ClassicRuleBornClassic extends ClassicRule {
    public ClassicRuleBornClassic(List<Integer> neighborsToCheck) {
        super(neighborsToCheck);
        if(neighborsToCheck.size() != 1) {
            throw new IllegalArgumentException("Illegal number of neighbors to check");
        }
    }
    public boolean isTrue(Cell classicCell, int neighbours) {
        return !classicCell.isAlive() && neighbours == neighboursToCheck.get(0);
    }
    public Cell execute() {
        return new ClassicCell(CellType.ALIVE);
    }
}
