package factory.cell;

import cell.*;

public class CellFactory implements  CellFactory {
    public ICell factory(char cellType) {
        if(cellType == '0')
            return new Cell(CellType.DEAD);
        else if (cellType == '1')
            return new Cell(CellType.ALIVE);
        else if (cellType == '2')
            return new Cell(CellType.STATE2);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
