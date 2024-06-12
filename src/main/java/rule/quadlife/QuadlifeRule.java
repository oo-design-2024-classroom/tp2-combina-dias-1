package rule.quadlife;

import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class QuadlifeRule implements Rule {
    CellType colorMajority(Map<CellType, Integer> neighbours) {
        int maxCount = neighbours.getOrDefault(CellType.RED, 0);
        CellType colorMax = CellType.RED;
        for (Map.Entry<CellType, Integer> entry : neighbours.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                colorMax = entry.getKey();
            }
        }
        return colorMax;
    }

}
