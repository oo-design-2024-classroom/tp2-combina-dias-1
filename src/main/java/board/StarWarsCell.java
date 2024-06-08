package board;

import cell.Cell;
import cell.CellType;
import rule.Rule;

import java.util.List;

public class StarWarsCell extends Board {
    public StarWarsCell(int rows, int col, List<Rule> rules) {
        super(rows, col, rules);
    }
    public Board nextGeneration() {
        Board classicBoard = new StarWarsCell(rows, columns, rules);
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                for(Rule rule : rules) { //TODO: CAMBIAR A POR SWITCH CON CASOS DE STATE CUANDO ESTÉN LISTAS LAS REGLAS
                    Cell actualClassicCell = getCell(row, col);
                    int state1NeighboursCant = getState1Neighbors(row, col);
                    if(rule.isTrue(actualClassicCell, state1NeighboursCant)) {
                        Cell newClassicCell = rule.execute();
                        classicBoard.setCell(row, col, newClassicCell);
                        break;
                    } else {
                        classicBoard.setCell(row, col, actualClassicCell);
                    }
                }
            }
        }
        return classicBoard;
    }
    private int getState1Neighbors(int row, int col) {
        List<Cell> neighbors = getAllNeighbors(row, col);
        int cant = 0;
        for(Cell neighbor : neighbors) {
            if(neighbor.getCellType() == CellType.ALIVE)
                cant++;
        }
        return cant;
    }
}
