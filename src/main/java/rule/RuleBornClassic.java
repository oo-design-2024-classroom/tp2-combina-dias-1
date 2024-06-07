package rule;
import cell.*;
import factory.cell.CellFactory;

import java.util.List;

public class RuleBornClassic extends Rule {
    public RuleBornClassic(List<Integer> neighborsToCheck) {
        super(neighborsToCheck);
        if(neighborsToCheck.size() != 1) {
            throw new IllegalArgumentException("Illegal number of neighbors to check");
        }
    }
    public boolean isTrue(Cell classicCell, int neighbours) {
        return !classicCell.isAlive() && neighbours == neighboursToCheck.get(0);
    }
    public ClassicCell execute() {
        return new ClassicCell(CellType.ALIVE);
    }
}
