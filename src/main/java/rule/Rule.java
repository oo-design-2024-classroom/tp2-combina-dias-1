package rule;

import board.Board;
import cell.Cell;

public abstract class Rule {
    Board board;
    public abstract Cell apply(int row, int col);
    public void setBoard(Board board) {
        this.board = board;
    }
}
