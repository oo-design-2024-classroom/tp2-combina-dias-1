package rule;

import cell.ClassicCell;
import cell.CellType;
import factory.cell.CellFactory;
import game.GameType;

import java.util.List;

public class RuleDieUnderpopulationClassic extends Rule {
    public RuleDieUnderpopulationClassic(List<Integer> neighboursToCheck, CellFactory cellFactory) {
        super(neighboursToCheck, cellFactory);
        if(neighboursToCheck.size() != 1)
            throw new IllegalArgumentException("Illegal number of neighbours to check");
    }
    public boolean isTrue(ClassicCell classicCell, int neighbours) {
        return neighbours < neighboursToCheck.get(0);
    }
    public ClassicCell execute() {
        return new ClassicCell(CellType.DEAD);
    }
}
