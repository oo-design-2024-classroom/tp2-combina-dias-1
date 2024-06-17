package factory;

import cell.Cell;
import cell.ICell;
import cell.CellType;

public class CellFactory {
    public ICell factory(char cellType) {
        if (cellType == 'X')
            return new Cell(CellType.DEAD);
        if (cellType == 'B')
            return new Cell(CellType.BLUE);
        if (cellType == 'R')
            return new Cell(CellType.RED);
        if(cellType == 'Y')
            return new Cell(CellType.YELLOW);
        if(cellType == 'G')
            return new Cell(CellType.GREEN);
        if(cellType == 'O')
            return new Cell(CellType.ALIVE);
        if(cellType == '2')
            return new Cell(CellType.STATE2);
        if(cellType == '3')
            return new Cell(CellType.ALMOST_DEAD);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
