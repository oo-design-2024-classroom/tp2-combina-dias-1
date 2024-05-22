package board;

import cell.Cell;
import java.util.Arrays;
import java.util.List;

import cell.CellType;
import rule.Rule;

public class Board implements IBoard {
    Cell[][] cells;
    List<Rule> rules;
    int rows;
    int columns;

    public Board(int row, int column, List<Rule> rules) {
        this.rows = row;
        this.columns = column;
        cells = new Cell[row][column];
        this.rules = rules;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                cells[i][j] = new Cell(CellType.DEAD);
        }
    }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    public void setCell(int row, int col, Cell cell) {
        cells[row][col] = cell;
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
    public Board nextGeneration() {
        Board board = new Board(rows, columns, rules);
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                for(Rule rule : rules) {
                    Cell actualCell = getCell(row, col);
                    int neighboursCant = getNeighbors(row, col);
                    if(rule.isTrue(actualCell, neighboursCant)) {
                        Cell newCell = rule.execute();
                        board.setCell(row, col, newCell);
                        break;
                    } else {
                      board.setCell(row, col, actualCell);
                    }
                }
            }
        }
        return board;
    }
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null)
            return false;
        if(o instanceof Board board) {
            if(rows != board.rows || columns != board.columns)
                return false;
            return Arrays.deepEquals(cells, board.cells);
        }
        return false;
    }
}