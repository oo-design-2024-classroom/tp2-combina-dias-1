package board;

import cell.Cell;

import java.util.List;
import java.util.ArrayList;
import rule.Rule;
public class Board {
    Cell[][] cells;
    List<Rule> rules = new ArrayList<>();

    public Board(int row, int column, Cell cellType) {
        cells = new Cell[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                cells[i][j] = cellType;
        }
    }
    public Board(Cell[][] cells) {
        this.cells = cells;
    }
    public void addRule(Rule rule) {
        rules.add(rule);
    }
    public void removeRule(Rule rule) {
        rules.remove(rule);
    }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    public void setCell(int row, int col, Cell cell) {
        cells[row][col] = cell;
    }
    public int getNeighbors(int row, int col) {
        if(!isValidPos(row, col))
            throw new IllegalArgumentException("Invalid position");
        int neighbors = 0;
        if(isValidPos(row - 1, col) && getCell(row - 1, col).isAlive())
            neighbors++;
        if(isValidPos(row, col - 1) && getCell(row, col - 1).isAlive())
            neighbors++;
        if(isValidPos(row + 1, col) && getCell(row + 1, col).isAlive())
            neighbors++;
        if(isValidPos(row, col + 1) && getCell(row, col).isAlive())
            neighbors++;
        return neighbors;
    }
    private boolean isValidPos(int row, int col) {
        return row >= 0 && row < cells.length && col >= 0 && col < cells[row].length;
    }
}