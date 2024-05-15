package cell;

public class Cell {
    private CellType type;
    public Cell(CellType type) {
        this.type = type;
    }

    public void setAlive(CellType type) {
        this.type = type;
    }
    public boolean isAlive() {
        return type == CellType.ALIVE;
    }
}
