package rule;

import cell.Cell;
import cell.ClassicCell;
import cell.CellType;
import factory.cell.CellFactory;
import game.GameType;

import java.util.List;

public class RuleDieOverpopulationClassic extends Rule {
    public RuleDieOverpopulationClassic(List<Integer> neighborsToCheck) {
        super(neighborsToCheck);
        if(neighborsToCheck.size() != 1)
            throw new IllegalArgumentException("Illegal number of neighbors to check");
    }
    public boolean isTrue(Cell classicCell, int neighbours) {
        return neighbours > neighboursToCheck.get(0);
    }
    public Cell execute() {
        return new ClassicCell(CellType.DEAD);
    }
}

