package rule;

import cell.Cell;
import cell.ClassicCell;
import factory.cell.CellFactory;
import game.GameType;

import java.util.List;

public abstract class Rule {
    protected List<Integer> neighboursToCheck;
    public Rule(List<Integer> neighboursToCheck) { //TODO: CAMBIAR CELLTYPE
        this.neighboursToCheck = neighboursToCheck;
    }
    public abstract boolean isTrue(Cell classicCell, int neighbours);
    public abstract Cell execute();
    public List<Integer> getNeighboursToCheck() { //for testing
        return neighboursToCheck;
    }
}
