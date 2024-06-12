package factory.board;

import board.*;
import factory.cell.CellFactory;
import rule.Rule;
import java.util.List;

public class BoardFactory {
    public Board factory(int rows, int columns, String boardString, List<Rule> rules, CellFactory cellFactory){
        Board board = new Board(rows, columns, rules);
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++){
                char cellChar = boardString.charAt(r * c + r);
                board.setCell(r,c,cellFactory.factory(cellChar));
            }
        }
        return board;
    }
}
