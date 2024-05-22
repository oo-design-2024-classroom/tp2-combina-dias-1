package factory;
import cell.*;
public class CellFactory {
    public Cell factory(char cellType) {
        if(cellType == 'O')
            return new Cell(CellType.ALIVE);
        else if (cellType == 'X')
            return new Cell(CellType.DEAD);
        else
            return null;
    }
}
