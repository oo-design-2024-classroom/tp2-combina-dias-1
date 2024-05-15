package rule;

import board.Board;

public abstract class Rule {
    private Board board;
    public void setBoard(Board board) {
        this.board = board;
    }
    abstract void rule(int row, int col);
}
