package rule.classic;

import board.Board;
import cell.Cell;
import cell.CellType;
import cell.ClassicCell;

import java.util.List;

public class RuleAliveClassic extends ClassicRule {
    @Override
    public Cell apply() {
        return new ClassicCell(CellType.DEAD);
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        Cell cell = board.getCell(row, column);
        if (!cell.isAlive()) return false;
        List<Cell> neighboursList = board.getAllNeighbors(row, column);
        int aliveNeighbours = countAliveNeighbours(neighboursList);
        if (cell.isAlive() && (aliveNeighbours == 2 || aliveNeighbours == 3)) return true;
        return !cell.isAlive() && aliveNeighbours == 3;
    }
}
