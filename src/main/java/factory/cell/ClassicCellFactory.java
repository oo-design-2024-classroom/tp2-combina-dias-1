package factory.cell;

import cell.*;

public class CellFactory implements CellFactory {
    public ICell factory(char cellType) {
        if(cellType == 'X')
            return new Cell(CellType.DEAD);
        else if (cellType == 'O')
            return new Cell(CellType.ALIVE);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
