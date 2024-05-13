import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoard {
    Board board;
    Cell cell;
    int rows = 5;
    int cols = 5;

    @Test
    public void createBoardWithAllCellsDead(){

        for(int row = 0; row<rows; row++){
            for(int col = 0; col < cols; col++){
                cell = board.getCell(row, col);
                assertFalse(cell.isAlive());
            }
        }
    }

    @Test
    public void addCelltoBoard(){
        board = new Board();
        board.addCell(0,1,ALIVE);
        cell = board.getCell(0,1);
        assertTrue(cell.isAlive());
    }

    @Test
    public void createPopulatedBoard(){
        int[][] populatedBoard = new int[][]{
                {DEAD, DEAD, DEAD, DEAD, ALIVE},
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD},
        };
        board = new Board(populatedBoard);
        cell = board.getCell(0,4);
        assertTrue(cell.isAlive());
    }
}
