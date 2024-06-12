package factory.cell;

import cell.Cell;
import cell.ICell;
import cell.CellType;

public class CellFactory implements CellFactory {
    public ICell factory(char cellType) {
        if (cellType == 'X')
            return new Cell(CellType.DEAD);
        if (cellType == 'B')
            return new Cell(CellType.BLUE);
        if (cellType == 'R')
            return new Cell(CellType.RED);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
