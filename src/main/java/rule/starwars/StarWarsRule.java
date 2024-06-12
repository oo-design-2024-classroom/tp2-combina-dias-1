package rule.starwars;

import cell.ICell;
import cell.Cell;
import rule.Rule;

import java.util.List;

public abstract class StarWarsRule implements Rule {
    int countState1Neighbours(List<ICell> neighbours){
        int count = 0;
        for (ICell cell : neighbours) {
            Cell SWCell = (Cell) cell;
            if (SWCell.isState1()) {
                count++;
            }
        }
        return count;
    }
}
