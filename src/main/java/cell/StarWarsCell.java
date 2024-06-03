package cell;

public class StarWarsCell implements Cell {
    private final CellType state;
    public StarWarsCell(CellType state) {
        this.state = state;
    }

    public boolean isAlive() {
        return state != CellType.DEAD;
    }

    public boolean equals(Object other) {
        if (other instanceof StarWarsCell otherCell)
            return state.equals(otherCell.state);
        return false;
    }
    public String toString() {
        if(state == CellType.DEAD)
            return "X";
        if(state == CellType.ALIVE)
            return "1";
        if(state == CellType.GENERIC_STATE_2)
            return "2";
        if(state == CellType.ALMOST_DEAD)
            return "3";
        throw new IllegalArgumentException("illegal cell");
    }
}
