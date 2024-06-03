package factory.cell;

import cell.*;

public class ClassicCellFactory implements CellFactory {
    public Cell factory(char cellType) {
        if(cellType == 'O')
            return new ClassicCell(CellType.DEAD);
        else if (cellType == '1')
            return new ClassicCell(CellType.ALIVE);
        else if (cellType == '2')
            return new ClassicCell(CellType.GENERIC_STATE_2);
        else if (cellType == '3')
            return new ClassicCell(CellType.ALMOST_DEAD);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
