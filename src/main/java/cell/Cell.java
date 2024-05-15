package cell;

public class Cell {
    private final CellType type;

    public Cell(CellType type) {
        this.type = type;
    }

    public boolean isAlive() {
        return type == CellType.ALIVE;
    }
}
