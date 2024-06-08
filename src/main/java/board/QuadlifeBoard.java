package board;

import cell.Cell;
import cell.CellType;
import rule.Rule;

import java.util.List;

public class QuadlifeBoard extends Board {
    public QuadlifeBoard(int rows, int cols, List<Rule> rules) {
        super(rows, cols, rules);
    }
    public Board nextGeneration() {
        Board newBoard = new QuadlifeBoard(rows, columns, rules);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                for (Rule rule : rules) {
                    Cell actualClassicCell = getCell(row, col);
                    CellType neighboursColor = mostFrequentColor(row, col);
                    if (rule.isTrue(actualClassicCell, neighboursColor.ordinal())) {
                        Cell newClassicCell = rule.execute();
                        newBoard.setCell(row, col, newClassicCell);
                        break;
                    } else {
                        newBoard.setCell(row, col, actualClassicCell);
                    }
                }
            }
        }
        return newBoard;
    }
}
