package cell;

public class StarWarsCell implements Cell {
    private final CellType type;
    public StarWarsCell(CellType type) {
        this.type = type;
    }

    public boolean isAlive(){return type == CellType.ALIVE;}
    public boolean isState0(){return type==CellType.DEAD;}
    public boolean isState1(){return type==CellType.ALIVE;}
    public boolean isState2(){return type==CellType.STATE2;}
    public boolean isState3(){return type==CellType.STATE3;}


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
        if(type == CellType.STATE2)
            return "2";
        if(type == CellType.STATE3)
            return "3";
        throw new IllegalArgumentException("illegal cell");
    }
}
