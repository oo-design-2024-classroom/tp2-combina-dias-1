package rule;
import cell.*;
import factory.cell.CellFactory;
import game.GameType;

import java.util.List;
import java.util.Objects;

public class RuleBornDifferentColor extends Rule {
    public RuleBornDifferentColor(List<Integer> neighborsToCheck, CellFactory cellFactory) {
        super(neighborsToCheck, cellFactory);
        if(neighborsToCheck.size() != 3) {
            throw new IllegalArgumentException("Illegal number of neighbors to check");
        }
    }
    public boolean isTrue(ClassicCell classicCell, int neighbours) {
        return !Objects.equals(neighboursToCheck.get(0), neighboursToCheck.get(1)) && !Objects.equals(neighboursToCheck.get(1), neighboursToCheck.get(2));
    }
    public Cell execute() {
        int missingColor = 6;
        missingColor -= neighboursToCheck.get(0) + neighboursToCheck.get(1) + neighboursToCheck.get(2);
        if(missingColor == 0)
            return cellFactory.factory('R'); //TODO: CAMBIAR CUANDO CAMBIEMOS CELL FACTORY
        else if (missingColor == 1)
            return cellFactory.factory('B');
        else if (missingColor == 2)
            return cellFactory.factory('Y');
        else if (missingColor == 3)
            return cellFactory.factory('G');
        else
            throw new IllegalArgumentException("Illegal color");
    }
}