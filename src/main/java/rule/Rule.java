package rule;

import board.Board;
import cell.ICell;

public interface Rule {
    ICell apply();
    boolean isApplicable(Board board, int row, int column);
}
