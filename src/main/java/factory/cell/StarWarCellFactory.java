package factory.cell;

import cell.Cell;
import cell.CellType;
import cell.StarWarsCell;

public class StarWarCellFactory implements CellFactory {
    public Cell factory(char cellType) {
        if(cellType == '0')
            return new StarWarsCell(CellType.DEAD);
        else if (cellType == '1')
            return new StarWarsCell(CellType.ALIVE);
        else if (cellType == '2')
            return new StarWarsCell(CellType.GENERIC_STATE_2);
        else if (cellType == '3')
            return new StarWarsCell(CellType.ALMOST_DEAD);
        throw new IllegalArgumentException("Invalid cell type: " + cellType);
    }
}
