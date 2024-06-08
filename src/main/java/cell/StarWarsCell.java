package cell;

public class StarWarsCell implements Cell {
    private final CellType type;
    public StarWarsCell(CellType type) {
        this.type = type;
    }

    public boolean isAlive() {
        return type != CellType.DEAD;
    }

    public boolean equals(Object other) {
        if (other instanceof StarWarsCell otherCell)
            return type.equals(otherCell.type);
        return false;
    }
    public CellType getCellType() {
        return type;
    }
    public String toString() {
        if(type == CellType.DEAD)
            return "X";
        if(type == CellType.ALIVE)
            return "1";
        if(type == CellType.GENERIC_STATE_2)
            return "2";
        if(type == CellType.ALMOST_DEAD)
            return "3";
        throw new IllegalArgumentException("illegal cell");
    }
}
