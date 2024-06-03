package factory.cell;

import cell.*;

public class QuadlifeCellFactory implements CellFactory {
    public Cell factory(char cellType) {
        if (cellType == 'X')
            return new QuadlifeCell(CellType.DEAD);
        if (cellType == 'B')
            return new QuadlifeCell(CellType.BLUE);
        if (cellType == 'R')
            return new QuadlifeCell(CellType.RED);
        if (cellType == 'G')
            return new QuadlifeCell(CellType.GREEN);
        if (cellType == 'Y')
            return new QuadlifeCell(CellType.YELLOW);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
