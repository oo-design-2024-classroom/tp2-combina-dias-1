package factory.cell;

import cell.*;

public class BriansBrainCellFactory implements  CellFactory {
    public Cell factory(char cellType) {
        if(cellType == '0')
            return new BriansBrainCell(CellType.DEAD);
        else if (cellType == '1')
            return new BriansBrainCell(CellType.ALIVE);
        else if (cellType == '2')
            return new BriansBrainCell(CellType.GENERIC_STATE_2);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
