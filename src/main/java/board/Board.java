package board;

import cell.Cell;
import cell.CellType;
import cell.ICell;
import rule.Rule;

import java.util.*;

public class Board {
    ICell[][] cells;
    int rows;
    int columns;
    List<Rule> rules;
    public Board(int rows, int columns, List<Rule> rules) {
        this.rows = rows;
        this.columns = columns;
        this.rules = rules;
        this.cells = new ICell[rows][columns];
    }
    public ICell getCell(int row, int col) {
        return cells[row][col];
    }
    public void setCell(int row, int col, ICell classicCell) {
        cells[row][col] = classicCell;
    }

    public Board nextGeneration() {
        Board board = new Board(rows, columns, rules);
        boolean ruleApplied = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                for (Rule rule : rules) {
                    if (rule.isApplicable(this, row, col)) {
                        ICell newCell = rule.apply();
                        board.setCell(row, col, newCell);
                        ruleApplied = true;
                        break;
                    } else {
                        board.setCell(row, col, new Cell(CellType.DEAD));
                    }
                }
                if (!ruleApplied) throw new IllegalStateException("no rule has been applied");
            }
        }
        return board;
    }

    public boolean isValidPos(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    public Map<CellType, Integer> countNeighboursTypes(int row, int col){
        Map<CellType, Integer> neighbours = new HashMap<>();
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if((i != 0 || j!=0) && isValidPos(row+i, col+j)){
                    CellType type = getCell(row+i, col+j).type();
                    if(neighbours.containsKey(type)){
                        neighbours.put(type, neighbours.get(type)+1);
                    } else {
                        neighbours.put(type, 1);
                    }
                }
            }
        }
        return neighbours;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null)
            return false;
        if(o instanceof Board classicBoard) {
            if(rows != classicBoard.rows || columns != classicBoard.columns)
                return false;
            return Arrays.deepEquals(cells, classicBoard.cells);
        }
        return false;
    }
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                output.append(getCell(i, j).toString());
            }
            output.append("\n");
        }
        return output.toString();
    }
}
