package rule;
import cell.*;
import rule.classic.ClassicRule;

import java.util.List;
import java.util.Objects;

public class RuleBornDifferentColor extends ClassicRule {
    public RuleBornDifferentColor(List<Integer> neighborsToCheck) {
        super(neighborsToCheck);
        if(neighborsToCheck.size() != 3) {
            throw new IllegalArgumentException("Illegal number of neighbors to check");
        }
    }
    public boolean isTrue(Cell classicCell, int neighbours) {
        return !Objects.equals(neighboursToCheck.get(0), neighboursToCheck.get(1)) && !Objects.equals(neighboursToCheck.get(1), neighboursToCheck.get(2));
    }
    public Cell execute() {
        int missingColor = 6;
        missingColor -= neighboursToCheck.get(0) + neighboursToCheck.get(1) + neighboursToCheck.get(2);
        if(missingColor == 0)
            return new QuadlifeCell(CellType.RED);
        else if (missingColor == 1)
            return new QuadlifeCell(CellType.BLUE); //CAMBIAR TODO
        else if (missingColor == 2)
            return new QuadlifeCell(CellType.YELLOW);
        else if (missingColor == 3)
            return new QuadlifeCell(CellType.GREEN);
        else
            throw new IllegalArgumentException("Illegal color");
    }
}