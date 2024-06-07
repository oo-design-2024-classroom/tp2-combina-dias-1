package rule.classic;

import cell.Cell;

import java.util.List;

public abstract class ClassicRule {
    protected List<Integer> neighboursToCheck;
    public ClassicRule(List<Integer> neighboursToCheck) { //TODO: CAMBIAR CELLTYPE
        this.neighboursToCheck = neighboursToCheck;
    }
    public abstract boolean isTrue(Cell classicCell, int neighbours);
    public abstract Cell execute();
    public List<Integer> getNeighboursToCheck() { //for testing
        return neighboursToCheck;
    }
}
