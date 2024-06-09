package rule.starwars;

import cell.Cell;
import cell.StarWarsCell;
import rule.Rule;

import java.util.List;

public abstract class StarWarsRule implements Rule {
    int countState1Neighbours(List<Cell> neighbours){
        int count = 0;
        for (Cell cell : neighbours) {
            StarWarsCell SWCell = (StarWarsCell) cell;
            if (SWCell.isState1()) {
                count++;
            }
        }
        return count;
    }
}
