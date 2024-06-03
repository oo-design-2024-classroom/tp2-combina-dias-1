package cell;

public class QuadlifeCell implements Cell {
    private final CellType type;
    public QuadlifeCell(CellType type) {
        this.type = type;
    }

    public boolean isAlive() {
        return type == CellType.ALIVE;
    }

    public boolean equals(Object other) {
        if (other instanceof QuadlifeCell otherCell)
            return type == otherCell.type;
        return false;
    }
    public String toString() {
        if(type == CellType.DEAD)
            return "X";
        if(type == CellType.BLUE)
            return "B";
        if(type == CellType.RED)
            return "R";
        if(type == CellType.GREEN)
            return "G";
        return "Y";
    }
}
