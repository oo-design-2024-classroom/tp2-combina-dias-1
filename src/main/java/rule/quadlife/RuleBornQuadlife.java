package rule.quadlife;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;

import java.util.Map;

public class RuleBornQuadlife extends QuadlifeRule {
    ICell cell;
    @Override
    public ICell apply() {
        if (cell == null) throw new IllegalStateException("Rule not checked if applicable before applying it.");
        return cell;
    }

    @Override
    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(CellType.RED) + neighbours.get(CellType.GREEN) + neighbours.get(CellType.BLUE) + neighbours.get(CellType.YELLOW);
        if(cell.type() == CellType.DEAD)
            return false;
        if (aliveNeighbours != 3) {
            CellType color = newColor(neighbours);
            cell = new Cell(color);
            return true;
        }
        return false;
    }
    private CellType newColor(Map<CellType,Integer> neighbours) {
        boolean differentColors = true;
        int remainingColor = 0;
        for(CellType type : neighbours.keySet()){
            if(neighbours.get(type) >= 2) {
                differentColors = false;
                break;
            }
        }
        if(differentColors) {
            for(CellType type : neighbours.keySet()){
                if(neighbours.get(type) == 0)
                    return type;
            }
        }
        return colorMajority(neighbours);
    }
}