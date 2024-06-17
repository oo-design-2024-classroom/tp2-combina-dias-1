package factory;

import board.*;
import rule.Rule;
import java.util.List;

public class BoardFactory {
    public Board factory(int rows, int columns, String boardString, List<Rule> rules, CellFactory cellFactory){
        Board board = new Board(rows, columns, rules);
        int actualRow = 0;
        int actualCol = 0;
        for(char c : boardString.toCharArray()) {
                if(c != '\n' && c != ' ' && c != '|') {
                    board.setCell(actualRow,actualCol,cellFactory.factory(c));
                    actualCol++;
                }
                if(actualCol == columns) {
                    actualRow++;
                    actualCol = 0;
                }
        }
        return board;
    }
}
