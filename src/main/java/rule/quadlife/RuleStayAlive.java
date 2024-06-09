package rule.quadlife;

import board.Board;
import cell.Cell;

public class RuleStayAlive extends QuadlifeRule {
    Cell cell;
    @Override
    public Cell apply() {
        if (cell == null) throw new IllegalStateException("Rule not checked if applicable before applying it.");
        return cell;
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        int aliveNeighbours = countAliveNeighbours(board.getAllNeighbors(row, column));
        return cell.isAlive() && (aliveNeighbours == 2 || aliveNeighbours == 3);
    }
}
