package rule.immigration;

import cell.Cell;
import cell.CellType;
import rule.Rule;

import java.util.List;

public abstract class RuleImmigration implements Rule {
    int countRedCells(List<Cell> neighbours){
        int count = 0;
        for (Cell cell : neighbours) {
            if (cell.getCellType() == CellType.RED) {
                count++;
            }
        }
        return count;
    }

    int countBlueCells(List<Cell> neighbours){
        int count = 0;
        for (Cell cell : neighbours) {
            if (cell.getCellType() == CellType.RED) {
                count++;
            }
        }
        return count;
    }

    int countAliveNeighbours(List<Cell> neighbours){
        int count = 0;
        for (Cell cell : neighbours) {
            if (cell.isAlive()) {
                count++;
            }
        }
        return count;
    }
}
