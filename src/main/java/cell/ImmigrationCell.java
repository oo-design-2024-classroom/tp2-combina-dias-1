package cell;

public class ImmigrationCell implements Cell {
    private final CellType type;
    public ImmigrationCell(CellType type) {
        this.type = type;
    }
    public boolean isAlive() {
        return type != CellType.DEAD;
    }
    public boolean equals(Object other) {
        if (other instanceof ImmigrationCell otherCell)
            return type == otherCell.type;
        return false;
    }
    public CellType getCellType() {
        return type;
    }
    public String toString() {
        if(type == CellType.DEAD)
            return "X";
        if(type == CellType.BLUE)
            return "B";
        if(type == CellType.RED)
            return "R";
        throw new IllegalArgumentException("Illegal type");
    }
}
