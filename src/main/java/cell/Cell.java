package cell;

public class Cell {
    private final CellType type;

    public Cell(CellType type) {
        this.type = type;
    }

    public boolean isAlive() {
        return type == CellType.ALIVE;
    }
    public boolean equals(Object other) {
        if (other instanceof Cell otherCell)
            return type == otherCell.type;
        return false;
    }
    public String toString() {
        if(type == CellType.ALIVE)
            return "O";
        return "X";
    }
}
