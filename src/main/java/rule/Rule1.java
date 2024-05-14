package rule;
import board.Board;
import cell.Cell;

public class Rule1 extends Rule {
    private Board board;

    public Rule1(Board board) {
        this.board = board;
    }

    public void rule(int row, int col) {
        if(!board.getCell(row,col).isAlive() && (board.getNeighbors(row, col) == 2 || board.getNeighbors(row,col) == 3))
            board.setCell(row,col, new Cell(true));
    }
}
