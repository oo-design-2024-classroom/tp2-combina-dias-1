package board;

import cell.Cell;

public interface IBoard {
    Cell getCell(int row, int col);
    void setCell(int row, int col, Cell cell);
    int getNeighbors(int row, int col);
    Board nextGeneration();
    String toString();
    boolean equals(Object o);
}
