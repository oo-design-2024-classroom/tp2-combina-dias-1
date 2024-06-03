package rule;

import cell.ClassicCell;
import cell.CellType;
import factory.cell.CellFactory;
import game.GameType;

import java.util.List;

public class RuleDieOverpopulationClassic extends Rule {
    public RuleDieOverpopulationClassic(List<Integer> neighborsToCheck, CellFactory cellFactory) {
        super(neighborsToCheck, cellFactory);
        if(neighborsToCheck.size() != 1)
            throw new IllegalArgumentException("Illegal number of neighbors to check");
    }
    public boolean isTrue(ClassicCell classicCell, int neighbours) {
        return neighbours > neighboursToCheck.get(0);
    }
    public ClassicCell execute() {
        return new ClassicCell(CellType.DEAD);
    }
}

