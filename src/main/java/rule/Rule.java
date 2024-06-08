package rule;

import cell.Cell;

import java.util.List;

public interface Rule {
    boolean isTrue(Cell classicCell, int neighbours);
    Cell execute();
    List<Integer> getNeighboursToCheck();
}
