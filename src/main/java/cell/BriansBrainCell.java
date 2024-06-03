package cell;

public class BriansBrainCell implements Cell {
    private final CellType type;
    public BriansBrainCell(CellType type) {
        this.type = type;
    }
    public boolean isAlive() {
        return type != CellType.DEAD;
    }
    public boolean equals(Object other) {
        if (other instanceof BriansBrainCell otherCell)
            return type == otherCell.type;
        return false;
    }
    public String toString() {
        if(type == CellType.DEAD)
            return "0";
        if(type == CellType.ALIVE)
            return "1";
        if(type == CellType.GENERIC_STATE_2)
            return "2";
        return "Y";
    }
}
