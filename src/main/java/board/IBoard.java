package board;

import cell.Cell;

public interface IBoard {
    int getRows();
    int getCols();
    void setCell(int row, int col, Cell cell);
    Cell getCell(int row, int col);
    int getNeighbors(int row, int col);
    void nextGeneration();
    String toString();
}
