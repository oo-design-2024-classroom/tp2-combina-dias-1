package factory;

import board.Board;
import cell.Cell;
import cell.CellType;
import rule.Rule;

import java.util.ArrayList;

public class BoardFactory {
    public static Board createBoard(int rows, int columns, String board) {
        if(!Board.checkValidStringBoard(board))
            throw new IllegalArgumentException("Invalid board");
        if(getRows(board) != rows || getColumns(board) != columns)
            throw new IllegalArgumentException("Invalid board");
        ArrayList<Rule> rules = new ArrayList<>();
        Board newBoard = new Board(rows, columns, new Cell(CellType.DEAD), rules);
        int actualRow = 0;
        int actualColumn = 0;
        for(int i = 0; i < board.length(); i++) {
            char actualChar = board.charAt(i);
            if(actualChar == 'X') {
                newBoard.setCell(actualRow, actualColumn, new Cell(CellType.DEAD));
            } else if(actualChar == 'O'){
                newBoard.setCell(actualRow, actualColumn, new Cell(CellType.ALIVE));
            }
            if(actualChar != ' ' && actualChar != '|'){
                actualRow++;
                actualColumn++;
            }
        }
        return newBoard;

    }
    private static int getRows(String board) {
        if(board.isEmpty())
            return 0;
        int rows = 1;
        for(int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == '\n' || board.charAt(i) == '|')
                rows++;
        }
        return rows;
    }
    private static int getColumns(String board) {
        if(board.isEmpty())
            return 0;
        int columns = 0;
        for(int i = 0; i < board.length(); i++) {
            if(board.charAt(i) != '\n' && board.charAt(i) != '|' && board.charAt(i) != ' ')
                columns++;
            else
                return columns;
        }
        return board.length();
    }
}
