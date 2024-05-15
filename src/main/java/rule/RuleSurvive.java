package rule;
import board.Board;
import cell.Cell;
import cell.CellType;

public class RuleSurvive extends Rule {
    private Board board;

    public RuleSurvive(Board board) {
        this.board = board;
    }

    public void rule(int row, int col) {
        if(board.getCell(row,col).isAlive() && (board.getNeighbors(row, col) == 2 || board.getNeighbors(row,col) == 3))
            board.setCell(row,col, new Cell(CellType.ALIVE));
    }
}
