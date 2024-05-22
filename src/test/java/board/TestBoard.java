package board;

import factory.BoardFactory;
import factory.RulesFactory;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import cell.*;
import rule.*;

import java.util.ArrayList;
import java.util.List;

public class TestBoard {
    Board board;
    Cell cell;
    int rows = 5;
    int cols = 5;
    List<Rule> rules;

    @BeforeEach
    public void setUp(){
        RulesFactory rulesFactory = new RulesFactory();
        BoardFactory boardFactory = new BoardFactory();
        rules = rulesFactory.factory("B3/S23");
    }

    @Test
    public void createBoardWithAllCellsDead(){
        board = new Board(rows, cols, new ArrayList<Rule>());
        for(int row = 0; row<rows; row++){
            for(int col = 0; col < cols; col++){
                cell = board.getCell(row, col);
                assertThat(cell.isAlive()).isFalse();
            }
        }
    }
    @Test
    public void addCellToBoard(){
        board = new Board(2,2, new ArrayList<Rule>());
        board.setCell(0,1,new Cell(CellType.ALIVE));
        cell = board.getCell(0,1);
        assertThat(cell.isAlive()).isTrue();
    }
    @Test
    public void testNoNeighbours() {
        board = new Board(3, 3, new ArrayList<Rule>());
        assertThat(board.getNeighbors(1,1)).isEqualTo(0);
    }
    @Test
    public void testNeighbours() {
        board = new Board(3, 3, new ArrayList<Rule>());
        board.setCell(0,0,new Cell(CellType.ALIVE));
        board.setCell(0,1,new Cell(CellType.ALIVE));
        board.setCell(2,2,new Cell(CellType.ALIVE));
        assertThat(board.getNeighbors(1,1)).isEqualTo(3);
    }
    @Test
    public void checkGeneration() {
        board = new Board(5,5, rules);
        board.setCell(1,2,new Cell(CellType.ALIVE));
        board.setCell(2,2,new Cell(CellType.ALIVE));
        board.setCell(3,2,new Cell(CellType.ALIVE));

        Board newBoard = board.nextGeneration();

        Board expected = new Board(5,5, rules);
        expected.setCell(2,1,new Cell(CellType.ALIVE));
        expected.setCell(2,2,new Cell(CellType.ALIVE));
        expected.setCell(2,3,new Cell(CellType.ALIVE));

        assertThat(newBoard).isEqualTo(expected);
    }
    @Test
    public void testGenerationCycle() {
        board = new Board(5,5, rules);
        board.setCell(1,2,new Cell(CellType.ALIVE));
        board.setCell(2,2,new Cell(CellType.ALIVE));
        board.setCell(3,2,new Cell(CellType.ALIVE));
        Board newBoard = board.nextGeneration();
        newBoard = newBoard.nextGeneration();
        assertThat(newBoard).isEqualTo(board);
    }

    @Test
    void testNotEqualsForCells(){
        board = new Board(5,5, rules);
        board.setCell(1,2,new Cell(CellType.ALIVE));
        Board newBoard = new Board(5,5, rules);
        assertThat(newBoard).isNotEqualTo(board);
    }

    @Test
    void testNotEqualsForSize(){
        board = new Board(5,5, rules);
        Board newBoard = new Board(4,4, rules);
        assertThat(newBoard).isNotEqualTo(board);
    }

    @Test
    void testValidStringBoard(){
        String board = "XXX\nXXX\nOOO\n";
        BoardFactory boardFactory = new BoardFactory();
        assertThat(boardFactory.checkValidStringBoard(board)).isTrue();
    }
    @Test
    void testInvalidStringBoard(){
        String board = "XXX\nOO\nXXX";
        BoardFactory boardFactory = new BoardFactory();
        assertThat(boardFactory.checkValidStringBoard(board)).isFalse();
    }

}
