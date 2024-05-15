package rule;
import cell.Cell;
import cell.CellType;

public class RuleBorn extends Rule {
    public Cell apply(int row, int col) {
        Cell cell = board.getCell(row, col);
        if(board.getNeighbors(row,col) == 3)
            board.setCell(row,col, new Cell(CellType.ALIVE));
        return cell;
    }
}
