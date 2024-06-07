package factory.cell;

import cell.Cell;
import cell.CellType;
import cell.ImmigrationCell;

public class ImmigrationCellFactory implements CellFactory {
    public Cell factory(char cellType) {
        if (cellType == 'X')
            return new ImmigrationCell(CellType.DEAD);
        if (cellType == 'B')
            return new ImmigrationCell(CellType.BLUE);
        if (cellType == 'R')
            return new ImmigrationCell(CellType.RED);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
