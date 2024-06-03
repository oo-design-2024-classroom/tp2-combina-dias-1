package cell;

public class ClassicCell implements Cell {
    private final CellType type;

    public ClassicCell(CellType type) {
        this.type = type;
    }

    public boolean isAlive() {
        return type == CellType.ALIVE;
    }

    public boolean equals(Object other) {
        if (other instanceof ClassicCell otherClassicCell)
            return type == otherClassicCell.type;
        return false;
    }
    public String toString() {
        if(type == CellType.ALIVE)
            return "O";
        else if(type == CellType.DEAD)
            return "X";
        return "?";
    }
}
