package board;

import cell.Cell;
import cell.CellType;
import cell.ImmigrationCell;
import cell.QuadlifeCell;
import rule.Rule;

import java.util.*;

public class ImmigrationBoard extends Board {
    public ImmigrationBoard(int row, int column, List<Rule> rules) {
        super(row, column, rules);
    }

    public Board nextGeneration() {
        Board newBoard = new ImmigrationBoard(rows, columns, rules);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if(distinctColors(col, row)) //TODO: PREGUNTAR, NO HACE FALTA FOR DE RULES ACÁ
                    setCell(row, col, remainingColor(col, row));
                for (Rule immigrationRule : rules) {
                    Cell actualClassicCell = getCell(row, col);
                    CellType neighboursColor = mostFrequentColor(row, col);
                    if (immigrationRule.isTrue(actualClassicCell, neighboursColor.ordinal())) {
                        Cell newClassicCell = immigrationRule.execute();
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
    private boolean distinctColors (int col, int row) {
        List<Cell> neighbors = getAllNeighbors(col, row);
        CellType color = neighbors.get(0).getCellType();
        for(Cell neighbor : neighbors) {
            if(!neighbor.isAlive())
                continue;
            if(color == neighbor.getCellType())
                return false;
        }
        return true;
    }
    public Cell remainingColor(int col, int row) {
        List<Cell> neighbors = getAllNeighbors(col, row);
        int missingColor = 6;
        missingColor -= neighbors.get(0).getCellType().ordinal() + neighbors.get(1).getCellType().ordinal() + neighbors.get(2).getCellType().ordinal();
        if(missingColor == 0)
            return new ImmigrationCell(CellType.RED);
        else if (missingColor == 1)
            return new ImmigrationCell(CellType.BLUE);
        else if (missingColor == 2)
            return new ImmigrationCell(CellType.YELLOW);
        else if (missingColor == 3)
            return new ImmigrationCell(CellType.GREEN);
        else
            throw new IllegalArgumentException("Illegal color");
    }
}