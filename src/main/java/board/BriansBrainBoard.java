package board;

import cell.Cell;
import rule.Rule;

import java.util.List;

public class BriansBrainBoard extends Board {
    public BriansBrainBoard(int cells, int row, List<Rule> rules) {
        super(cells, row, rules);
    }
    public Board nextGeneration() {
        Board classicBoard = new BriansBrainBoard(rows, columns, rules);
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
