package factory;

import board.Board;
import rule.Rule;

import java.util.List;

public class BoardFactory {
    public Board factory(int rows, int columns, String board, List<Rule> rules) {
        CellFactory cellFactory = new CellFactory();
        if(!checkValidStringBoard(board))
            throw new IllegalArgumentException("Invalid board");
        if(getRows(board) != rows || getColumns(board) != columns)
            throw new IllegalArgumentException("Invalid board");
        Board newBoard = new Board(rows, columns, rules);
        int actualRow = 0;
        int actualColumn = 0;
        for(int i = 0; i < board.length(); i++) {
            char actualChar = board.charAt(i);
            if (actualChar == 'X' || actualChar == 'O') {
                newBoard.setCell(actualRow, actualColumn, cellFactory.factory(actualChar));
                actualColumn++;
            } else if (actualChar == '\n') {
                actualRow++;
                actualColumn = 0;
            }
        }
        return newBoard;
    }
    private int getRows(String board) {
        if(board.isEmpty())
            return 0;
        int rows = 1;
        for(int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == '\n' || board.charAt(i) == '|')
                rows++;
        }
        return rows;
    }
    private int getColumns(String board) {
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
    public boolean checkValidStringBoard(String board) {
        int columns = 0;
        for(int i = 0; i < board.length(); i++) {
            if(board.charAt(i) == '|' || board.charAt(i) == '\n')
                break;
            columns++;
        }
        int cantColumnsAtTheMoment = 0;
        for(int j = 0; j < board.length(); j++) {
            if(board.charAt(j) == '\n' && cantColumnsAtTheMoment != columns) {
                return false;
            } else if(board.charAt(j) == '\n') {
                cantColumnsAtTheMoment = 0;
            } else if (board.charAt(j) != '|' && board.charAt(j) != ' '){
                cantColumnsAtTheMoment++;
            }
        }
        return true;
    }
}
