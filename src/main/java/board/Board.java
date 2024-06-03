package board;

import cell.ClassicCell;
import rule.Rule;

import java.util.Arrays;
import java.util.List;

public abstract class Board {
    ClassicCell[][] classicCells;
    List<Rule> rules;
    int rows;
    int columns;
    public Board(int rows, int columns, List<Rule> rules) {
        this.rows = rows;
        this.columns = columns;
        classicCells = new ClassicCell[rows][columns];
        this.rules = rules;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                classicCells[i][j] = null;
        }
    }
    public Board(int rows, int columns, List<Rule> rules, ClassicCell[][] classicCells) {
        this.rows = rows;
        this.columns = columns;
        this.classicCells = classicCells;
        this.rules = rules;
    }
    public ClassicCell getCell(int row, int col) {
        return classicCells[row][col];
    }
    public void setCell(int row, int col, ClassicCell classicCell) {
        classicCells[row][col] = classicCell;
    }

    public abstract int getNeighbors(int row, int col);
    public abstract Board nextGeneration();
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                output.append(getCell(i, j).toString()).append(" ");
            }
            output.append("|\n");
        }
        return output.toString();
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null)
            return false;
        if(o instanceof ClassicBoard classicBoard) {
            if(rows != classicBoard.rows || columns != classicBoard.columns)
                return false;
            return Arrays.deepEquals(classicCells, classicBoard.classicCells);
        }
        return false;
    }
}
