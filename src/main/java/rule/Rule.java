package rule;

import board.Board;
import cell.Cell;

public abstract class Rule {
    public abstract boolean isTrue(Cell cell, int neighbours);
    public abstract Cell execute();
}
