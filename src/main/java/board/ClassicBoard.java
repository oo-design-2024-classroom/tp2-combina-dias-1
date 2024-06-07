package board;

import cell.*;
import java.util.List;

import rule.classic.ClassicRule;

public class ClassicBoard extends Board {

    public ClassicBoard(int row, int column, List<ClassicRule> classicRules) {
        super(row, column, classicRules);
    }
    public int getNeighbors(int row, int col) {
        if (!isValidPos(row, col))
            throw new IllegalArgumentException("Invalid position");
        int neighbors = 0;
        if (isValidPos(row - 1, col - 1) && getCell(row - 1, col - 1).isAlive()) neighbors++;
        if (isValidPos(row - 1, col) && getCell(row - 1, col).isAlive()) neighbors++;
        if (isValidPos(row - 1, col + 1) && getCell(row - 1, col + 1).isAlive()) neighbors++;
        if (isValidPos(row, col - 1) && getCell(row, col - 1).isAlive()) neighbors++;
        if (isValidPos(row, col + 1) && getCell(row, col + 1).isAlive()) neighbors++;
        if (isValidPos(row + 1, col - 1) && getCell(row + 1, col - 1).isAlive()) neighbors++;
        if (isValidPos(row + 1, col) && getCell(row + 1, col).isAlive()) neighbors++;
        if (isValidPos(row + 1, col + 1) && getCell(row + 1, col + 1).isAlive()) neighbors++;
        return neighbors;
    }
    private boolean isValidPos(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    public ClassicBoard nextGeneration() {
        ClassicBoard classicBoard = new ClassicBoard(rows, columns, classicRules);
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                for(ClassicRule classicRule : classicRules) {
                    Cell actualClassicCell = getCell(row, col);
                    int neighboursCant = getNeighbors(row, col);
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