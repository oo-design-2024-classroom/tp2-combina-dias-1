package board;

import factory.board.ClassicBoardFactory;
import factory.rules.ClassicRulesFactory;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import cell.*;
import rule.classic.ClassicRule;

import java.util.ArrayList;
import java.util.List;

public class TestClassicBoard {
    ClassicBoard classicBoard;
    ClassicCell classicCell;
    List<ClassicRule> classicRules;

    @BeforeEach
    public void setUp(){
        ClassicRulesFactory classicRulesFactory = new ClassicRulesFactory();
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        classicRules = classicRulesFactory.factory("B3/S23");
    }

    @Test
    public void addCellToBoard(){
        classicBoard = new ClassicBoard(2,2, new ArrayList<ClassicRule>());
        classicBoard.setCell(0,1,new ClassicCell(CellType.ALIVE));
        classicCell = classicBoard.getCell(0,1);
        assertThat(classicCell.isAlive()).isTrue();
    }
    @Test
    public void testNoNeighbours() {
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        ClassicRulesFactory classicRulesFactory = new ClassicRulesFactory();
        classicRules = classicRulesFactory.factory("B3/S23");
        classicBoard = classicBoardFactory.factory(3,3,"XXX\nXXX\nXXX", classicRules);

        assertThat(classicBoard.getNeighbors(1,1)).isEqualTo(0);
    }
    @Test
    public void testNeighbours() {
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        ClassicRulesFactory classicRulesFactory = new ClassicRulesFactory();
        classicRules = classicRulesFactory.factory("B3/S23");
        classicBoard = classicBoardFactory.factory(3,3,"XXX\nOXO\nXOX", classicRules);
        assertThat(classicBoard.getNeighbors(1,1)).isEqualTo(3);
    }
    @Test
    public void checkGeneration() {
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        ClassicRulesFactory classicRulesFactory = new ClassicRulesFactory();
        classicRules = classicRulesFactory.factory("B3/S23");
        classicBoard = classicBoardFactory.factory(5,5,"XXXXX\nXXOXX\nXXOXX\nXXOXX\nXXXXX", classicRules);
        ClassicBoard newClassicBoard = classicBoard.nextGeneration();

        ClassicBoard expected = classicBoardFactory.factory(5,5,"XXXXX\nXXXXX\nXOOOX\nXXXXX\nXXXXX", classicRules);

        assertThat(newClassicBoard).isEqualTo(expected);
    }
    @Test
    public void testGenerationCycle() {
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        ClassicRulesFactory classicRulesFactory = new ClassicRulesFactory();
        classicRules = classicRulesFactory.factory("B3/S23");
        classicBoard = classicBoardFactory.factory(5,5,"XXXXX\nXXOXX\nXXOXX\nXXOXX\nXXXXX", classicRules);
        ClassicBoard newClassicBoard = classicBoard.nextGeneration();
        newClassicBoard = newClassicBoard.nextGeneration();
        assertThat(newClassicBoard).isEqualTo(classicBoard);
    }

    @Test
    void testNotEqualsForCells(){
        classicBoard = new ClassicBoard(5,5, classicRules);
        classicBoard.setCell(1,2,new ClassicCell(CellType.ALIVE));
        ClassicBoard newClassicBoard = new ClassicBoard(5,5, classicRules);
        assertThat(newClassicBoard).isNotEqualTo(classicBoard);
    }

    @Test
    void testNotEqualsForSize(){
        classicBoard = new ClassicBoard(5,5, classicRules);
        ClassicBoard newClassicBoard = new ClassicBoard(4,4, classicRules);
        assertThat(newClassicBoard).isNotEqualTo(classicBoard);
    }

    @Test
    void testValidStringBoard(){
        String board = "XXX\nXXX\nOOO\n";
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        assertThat(classicBoardFactory.checkValidStringBoard(board)).isTrue();
    }
    @Test
    void testInvalidStringBoard(){
        String board = "XXX\nOO\nXXX";
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        assertThat(classicBoardFactory.checkValidStringBoard(board)).isFalse();
    }
}
