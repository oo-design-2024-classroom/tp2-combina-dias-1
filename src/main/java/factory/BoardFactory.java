package factory;

import board.*;
import rule.Rule;
import java.util.List;

public class BoardFactory {
    public IBoard factory(int rows, int columns, String boardString, List<Rule> rules, CellFactory cellFactory){
        IBoard board = new Board(rows, columns, rules);
        int actualRow = 0;
        int actualCol = 0;
        String[] rowsStrings = boardString.split("\n");
        if(rowsStrings.length != rows)
            throw new IllegalArgumentException("Invalid board string");
        for(String rowString : rowsStrings) {
            if (rowString.length() != columns)
                throw new IllegalArgumentException("Invalid board string");
            for(char c : rowString.toCharArray()) {
                board.setCell(actualRow, actualCol, cellFactory.factory(c));
                actualCol++;
            }
            actualRow++;
            actualCol = 0;
        }
        return board;
    }
}
