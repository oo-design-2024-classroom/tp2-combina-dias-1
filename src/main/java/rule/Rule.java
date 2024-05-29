package rule;

import cell.Cell;

import java.util.List;

public abstract class Rule {
    protected List<Integer> neighboursToCheck;
    public Rule(List<Integer> neighboursToCheck) {
        this.neighboursToCheck = neighboursToCheck;
    }
    public abstract boolean isTrue(Cell cell, int neighbours);
    public abstract Cell execute();
    public List<Integer> getNeighboursToCheck() { //for testing
        return neighboursToCheck;
    }
}
