package rule;

import cell.Cell;
import cell.ClassicCell;
import factory.cell.CellFactory;
import game.GameType;

import java.util.List;

public abstract class Rule {
    protected List<Integer> neighboursToCheck;
    CellFactory cellFactory;
    public Rule(List<Integer> neighboursToCheck, CellFactory cellFactory) { //TODO: CAMBIAR CELLTYPE
        this.neighboursToCheck = neighboursToCheck;
        this.cellFactory = cellFactory;
    }
    public abstract boolean isTrue(ClassicCell classicCell, int neighbours);
    public abstract Cell execute();
    public List<Integer> getNeighboursToCheck() { //for testing
        return neighboursToCheck;
    }
}
