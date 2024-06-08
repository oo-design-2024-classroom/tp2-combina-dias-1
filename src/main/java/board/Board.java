package board;

import cell.Cell;
import cell.CellType;
import rule.Rule;

import java.util.*;

public abstract class Board {
    Cell[][] cells;
    int rows;
    int columns;
    List<Rule> rules;
    public Board(int rows, int columns, List<Rule> rules) {
        this.rows = rows;
        this.columns = columns;
        this.rules = rules;
    }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    public void setCell(int row, int col, Cell classicCell) {
        cells[row][col] = classicCell;
    }
    public abstract Board nextGeneration();
    public boolean isValidPos(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
    public int getAliveNeighborsCant(int row, int col) {
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
    public List<Cell> getAllNeighbors(int row, int col) {
        List<Cell> neighbors = new ArrayList<>();
        if (isValidPos(row - 1, col - 1) && getCell(row - 1, col - 1).isAlive()) neighbors.add(getCell(row - 1, col));
        if (isValidPos(row - 1, col) && getCell(row - 1, col).isAlive()) neighbors.add(getCell(row - 1, col));
        if (isValidPos(row - 1, col + 1) && getCell(row - 1, col + 1).isAlive())
            neighbors.add(getCell(row - 1, col + 1));
        if (isValidPos(row, col - 1) && getCell(row, col - 1).isAlive()) neighbors.add(getCell(row, col - 1));
        if (isValidPos(row, col + 1) && getCell(row, col + 1).isAlive()) neighbors.add(getCell(row, col + 1));
        if (isValidPos(row + 1, col - 1) && getCell(row + 1, col - 1).isAlive())
            neighbors.add(getCell(row + 1, col - 1));
        if (isValidPos(row + 1, col) && getCell(row + 1, col).isAlive()) neighbors.add(getCell(row + 1, col));
        if (isValidPos(row + 1, col + 1) && getCell(row + 1, col + 1).isAlive())
            neighbors.add(getCell(row + 1, col + 1));
        return neighbors;
    }
    public CellType mostFrequentColor(int row, int col) { //TODO: probablemente lo tenga que hacer la regla, no la clase immigration board && preguntar: no quiero repetir código pero no debería ponerlo acá porque no todos lo board lo usan :s
        EnumMap<CellType, Integer> colorOccurrences = new EnumMap<>(CellType.class);
        for (CellType type : CellType.values()) {
            if (!(type == CellType.BLUE || type == CellType.RED || type == CellType.GREEN || type == CellType.YELLOW))
                continue;
            colorOccurrences.put(type, 0);
        }
        List<Cell> neighbors = getAllNeighbors(row, col);
        for (Cell neighbor : neighbors) {
            if (!neighbor.isAlive())
                continue;
            CellType actualCellType = neighbor.getCellType();
            colorOccurrences.put(actualCellType, colorOccurrences.get(actualCellType) + 1);
        }
        CellType mostFrequentColor = null;
        int maxOccurrences = Integer.MIN_VALUE;
        for (Map.Entry<CellType, Integer> entry : colorOccurrences.entrySet()) {
            if (entry.getValue() > maxOccurrences) {
                maxOccurrences = entry.getValue();
                mostFrequentColor = entry.getKey();
            }
        }
        return mostFrequentColor;
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
                output.append(getCell(i, j).toString()).append(" ");
            }
            output.append("|\n");
        }
        return output.toString();
    }
}
