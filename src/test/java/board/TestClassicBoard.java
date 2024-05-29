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

public class TestClassicBoard {
    ClassicBoard classicBoard;
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
        classicBoard = new ClassicBoard(rows, cols, new ArrayList<Rule>());
        for(int row = 0; row<rows; row++){
            for(int col = 0; col < cols; col++){
                cell = classicBoard.getCell(row, col);
                assertThat(cell.isAlive()).isFalse();
            }
        }
    }
    @Test
    public void addCellToBoard(){
        classicBoard = new ClassicBoard(2,2, new ArrayList<Rule>());
        classicBoard.setCell(0,1,new Cell(CellType.ALIVE));
        cell = classicBoard.getCell(0,1);
        assertThat(cell.isAlive()).isTrue();
    }
    @Test
    public void testNoNeighbours() {
        classicBoard = new ClassicBoard(3, 3, new ArrayList<Rule>());
        assertThat(classicBoard.getNeighbors(1,1)).isEqualTo(0);
    }
    @Test
    public void testNeighbours() {
        classicBoard = new ClassicBoard(3, 3, new ArrayList<Rule>());
        classicBoard.setCell(0,0,new Cell(CellType.ALIVE));
        classicBoard.setCell(0,1,new Cell(CellType.ALIVE));
        classicBoard.setCell(2,2,new Cell(CellType.ALIVE));
        assertThat(classicBoard.getNeighbors(1,1)).isEqualTo(3);
    }
    @Test
    public void checkGeneration() {
        classicBoard = new ClassicBoard(5,5, rules);
        classicBoard.setCell(1,2,new Cell(CellType.ALIVE));
        classicBoard.setCell(2,2,new Cell(CellType.ALIVE));
        classicBoard.setCell(3,2,new Cell(CellType.ALIVE));

        ClassicBoard newClassicBoard = classicBoard.nextGeneration();

        ClassicBoard expected = new ClassicBoard(5,5, rules);
        expected.setCell(2,1,new Cell(CellType.ALIVE));
        expected.setCell(2,2,new Cell(CellType.ALIVE));
        expected.setCell(2,3,new Cell(CellType.ALIVE));

        assertThat(newClassicBoard).isEqualTo(expected);
    }
    @Test
    public void testGenerationCycle() {
        classicBoard = new ClassicBoard(5,5, rules);
        classicBoard.setCell(1,2,new Cell(CellType.ALIVE));
        classicBoard.setCell(2,2,new Cell(CellType.ALIVE));
        classicBoard.setCell(3,2,new Cell(CellType.ALIVE));
        ClassicBoard newClassicBoard = classicBoard.nextGeneration();
        newClassicBoard = newClassicBoard.nextGeneration();
        assertThat(newClassicBoard).isEqualTo(classicBoard);
    }

    @Test
    void testNotEqualsForCells(){
        classicBoard = new ClassicBoard(5,5, rules);
        classicBoard.setCell(1,2,new Cell(CellType.ALIVE));
        ClassicBoard newClassicBoard = new ClassicBoard(5,5, rules);
        assertThat(newClassicBoard).isNotEqualTo(classicBoard);
    }

    @Test
    void testNotEqualsForSize(){
        classicBoard = new ClassicBoard(5,5, rules);
        ClassicBoard newClassicBoard = new ClassicBoard(4,4, rules);
        assertThat(newClassicBoard).isNotEqualTo(classicBoard);
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
