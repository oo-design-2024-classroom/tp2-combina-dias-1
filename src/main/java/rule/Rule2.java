package rule;

import board.Board;
import cell.Cell;
import cell.CellType;

public class Rule2 extends Rule {
    private Board board;

    public Rule2(Board board) {
        this.board = board;
    }
    public void rule(int row, int col) {
        if(board.getCell(row, col).isAlive() && board.getNeighbors(row, col) < 2)
            board.setCell(row, col, new Cell(CellType.DEAD));
    }
}
