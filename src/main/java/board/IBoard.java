package board;
import cell.ICell;
import cell.CellType;
import java.util.Map;

public interface IBoard {
    ICell getCell(int row, int col);
    void setCell(int row, int col, ICell cell);
    IBoard nextGeneration();
    boolean isValidPos(int row, int col);
    Map<CellType, Integer> countNeighboursTypes(int row, int col);
    boolean equals(Object o);
    String toString();
}
