package rule.quadlife;

import cell.Cell;
import cell.CellType;
import rule.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class QuadlifeRule implements Rule {
    CellType colorMajority(List<Cell> neighbours) {
        HashMap<CellType, Integer> count = new HashMap<>();
        for (Cell cell : neighbours) {
            CellType cellType = cell.getCellType();
            if (cellType != CellType.DEAD){
                count.put(cellType, count.getOrDefault(cellType, 0) + 1);
            }
        }
        CellType majorityType = null;
        int maxCount = 0;
        for (Map.Entry<CellType, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorityType = entry.getKey();
            }
        }
        if (majorityType == null) {
            throw new IllegalStateException("No majority color found");
        }
        return majorityType;
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
