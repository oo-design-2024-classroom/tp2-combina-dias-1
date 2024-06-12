package cell;


public class Cell implements ICell {
    public final CellType type;

    public Cell(CellType type) {
        this.type = type;
    }

    public boolean equals(Object other) {
        if (other instanceof Cell otherCell)
            return type.equals(otherCell.type);
        return false;
    }

    @Override
    public String toString() {
        return switch (type) {
            case RED -> "R";
            case BLUE -> "B";
            case YELLOW -> "Y";
            case GREEN -> "G";
            case ALIVE -> "A";
            case STATE2 -> "2";
            case STATE3 -> "3";
            case ALMOST_DEAD -> "D";
            case DEAD -> "X";
            default -> throw new IllegalArgumentException("Unknown cell type: " + this);
        };
    }

    @Override
    public CellType type() {
        return type;
    }
}
