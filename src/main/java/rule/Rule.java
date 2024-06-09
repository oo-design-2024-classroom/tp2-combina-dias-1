package rule;

import board.Board;
import cell.Cell;

public interface Rule {
    Cell apply();
    boolean isApplicable(Board board, int row, int column);
}
