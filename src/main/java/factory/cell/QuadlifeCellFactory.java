package factory.cell;

import cell.*;

public class QuadlifeCellFactory implements CellFactory {
    public ICell factory(char cellType) {
        if (cellType == 'X')
            return new Cell(CellType.DEAD);
        if (cellType == 'B')
            return new Cell(CellType.BLUE);
        if (cellType == 'R')
            return new Cell(CellType.RED);
        if (cellType == 'G')
            return new Cell(CellType.GREEN);
        if (cellType == 'Y')
            return new Cell(CellType.YELLOW);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
