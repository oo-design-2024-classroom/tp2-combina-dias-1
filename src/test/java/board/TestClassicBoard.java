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
    List<Rule> rules;

    @BeforeEach
    public void setUp(){
        RulesFactory rulesFactory = new RulesFactory();
        BoardFactory boardFactory = new BoardFactory();
        rules = rulesFactory.factory("B3/S23");
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
        BoardFactory boardFactory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        rules = rulesFactory.factory("B3/S23");
        classicBoard = boardFactory.factory(3,3,"XXX\nXXX\nXXX", rules);

        assertThat(classicBoard.getNeighbors(1,1)).isEqualTo(0);
    }
    @Test
    public void testNeighbours() {
        BoardFactory boardFactory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        rules = rulesFactory.factory("B3/S23");
        classicBoard = boardFactory.factory(3,3,"XXX\nOXO\nXOX", rules);
        assertThat(classicBoard.getNeighbors(1,1)).isEqualTo(3);
    }
    @Test
    public void checkGeneration() {
        BoardFactory boardFactory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        rules = rulesFactory.factory("B3/S23");
        classicBoard = boardFactory.factory(5,5,"XXXXX\nXXOXX\nXXOXX\nXXOXX\nXXXXX", rules);
        ClassicBoard newClassicBoard = classicBoard.nextGeneration();

        ClassicBoard expected = boardFactory.factory(5,5,"XXXXX\nXXXXX\nXOOOX\nXXXXX\nXXXXX", rules);

        assertThat(newClassicBoard).isEqualTo(expected);
    }
    @Test
    public void testGenerationCycle() {
        BoardFactory boardFactory = new BoardFactory();
        RulesFactory rulesFactory = new RulesFactory();
        rules = rulesFactory.factory("B3/S23");
        classicBoard = boardFactory.factory(5,5,"XXXXX\nXXOXX\nXXOXX\nXXOXX\nXXXXX", rules);
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
