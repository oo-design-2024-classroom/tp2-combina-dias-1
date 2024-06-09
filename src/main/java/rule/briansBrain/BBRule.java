package rule.briansBrain;

import cell.Cell;
import rule.Rule;

import java.util.List;

public abstract class BBRule implements Rule {
    int countAliveNeighbours(List<Cell> neighbours){
        int count = 0;
        for (Cell cell : neighbours) {
            if (cell.isAlive()) {
                count++;
            }
        }
        return count;
    }
}
