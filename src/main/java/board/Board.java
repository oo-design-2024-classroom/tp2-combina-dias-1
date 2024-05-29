package board;

import cell.Cell;
import cell.CellType;
import rule.Rule;

import java.util.Arrays;
import java.util.List;

public abstract class Board {
    Cell[][] cells;
    List<Rule> rules;
    int rows;
    int columns;
    public Board(int rows, int columns, List<Rule> rules) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
        this.rules = rules;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                cells[i][j] = null;
        }
    }
    public Board(int rows, int columns, List<Rule> rules, Cell[][] cells) {
        this.rows = rows;
        this.columns = columns;
        this.cells = cells;
        this.rules = rules;
    }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    public void setCell(int row, int col, Cell cell) {
        cells[row][col] = cell;
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
            return Arrays.deepEquals(cells, classicBoard.cells);
        }
        return false;
    }
}
