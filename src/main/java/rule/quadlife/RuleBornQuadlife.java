package rule.quadlife;

import board.Board;
import cell.Cell;
import cell.ICell;
import cell.CellType;
import rule.Rule;

import java.util.Map;

import static cell.CellType.*;

public class RuleBornQuadlife implements Rule {
    ICell cell;

    public ICell apply() {
        if (cell == null) throw new IllegalStateException("Rule not checked if applicable before applying it.");
        return cell;
    }


    public boolean isApplicable(Board board, int row, int column) {
        cell = board.getCell(row, column);
        Map<CellType,Integer> neighbours = board.countNeighboursTypes(row,column);
        int aliveNeighbours = neighbours.get(RED) + neighbours.get(GREEN) + neighbours.get(BLUE) + neighbours.get(CellType.YELLOW);
        if(cell.type() != CellType.DEAD)
            return false;
        if (aliveNeighbours == 3) {
            CellType color = newColor(neighbours);
            cell = new Cell(color);
            return true;
        }
        return false;
    }
    private CellType newColor(Map<CellType,Integer> neighbours) {
        CellType[] colors = {GREEN, RED, BLUE, YELLOW};
        for(CellType type : colors){
            if(neighbours.get(type) >= 2) {
                return type;
            }
        }
        for(CellType type : colors){
            if(neighbours.get(type) == 0)
                return type;
            }
        return null;
    }
}