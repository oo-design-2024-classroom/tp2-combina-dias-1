package board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cell.*;

public class TestBoard {
    Board board;
    Cell cell;
    int rows = 5;
    int cols = 5;

    @Test
    public void createBoardWithAllCellsDead(){
        board = new Board(rows, cols, new Cell(CellType.DEAD));
        for(int row = 0; row<rows; row++){
            for(int col = 0; col < cols; col++){
                cell = board.getCell(row, col);
                assertThat(cell.isAlive()).isFalse();
            }
        }
    }

    @Test
    public void addCellToBoard(){
        board = new Board(2,2,new Cell(CellType.DEAD));
        board.setCell(0,1,new Cell(CellType.ALIVE));
        cell = board.getCell(0,1);
        assertTrue(cell.isAlive());
    }
}
