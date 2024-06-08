package board;

import cell.*;

import java.util.List;
import rule.Rule;
public class ClassicBoard extends Board {

    public ClassicBoard(int rows, int columns, List<Rule> classicRules) {
        super(rows, columns, classicRules);
    }
    public Board nextGeneration() {
        Board classicBoard = new ClassicBoard(rows, columns, rules);
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                for(Rule classicRule : rules) {
                    Cell actualClassicCell = getCell(row, col);
                    int neighboursCant = getAliveNeighborsCant(row, col);
                    if(classicRule.isTrue(actualClassicCell, neighboursCant)) {
                        Cell newClassicCell = classicRule.execute();
                        classicBoard.setCell(row, col, newClassicCell);
                        break;
                    } else {
                      classicBoard.setCell(row, col, actualClassicCell);
                    }
                }
            }
        }
        return classicBoard;
    }
}