package rule;
import cell.Cell;
import cell.CellType;

public class RuleBorn extends Rule {
    public boolean isTrue(Cell cell, int neighbours) {
        return !cell.isAlive() && neighbours == 3;
    }
    public Cell execute() {
        return new Cell(CellType.ALIVE);
    }
}
