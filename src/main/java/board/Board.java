package board;

import cell.Cell;

import java.util.Arrays;
import java.util.List;

import cell.CellType;
import rule.Rule;

public class Board implements IBoard {
    Cell[][] cells;
    List<Rule> rules;
    int rows;
    int columns;
    Cell cellType;

    public Board(int row, int column, Cell cellType, List<Rule> rules) {
        this.rows = row;
        this.columns = column;
        cells = new Cell[row][column];
        this.rules = rules;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                cells[i][j] = cellType;
        }
        this.cellType = cellType;
    }

    public static Board fromString(String board, List<Rule> rules) {
        if(!checkValidStringBoard(board))
            throw new IllegalArgumentException("Invalid board");

        String[] rows = board.split("\\|\\n");
        int rowsCant = rows.length;
        int columnsCant = rows[0].length();
        Board newBoard = new Board(rowsCant, columnsCant, new Cell(CellType.DEAD), rules);
        for(int i = 0; i < rowsCant; i++) {
            String[] columns = rows[i].split("");
            for(int j = 0; j < columnsCant; j++) {
                if(columns[j].equals("O")) {
                    newBoard.setCell(i, j, new Cell(CellType.ALIVE));
                } else {
                    newBoard.setCell(i, j, new Cell(CellType.DEAD));
                }
            }
        }
        return newBoard;
    }


    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    public void setCell(int row, int col, Cell cell) {
        cells[row][col] = cell;
    }

    public int getNeighbors(int row, int col) {
        if(!isValidPos(row, col))
            throw new IllegalArgumentException("Invalid position");
        int neighbors = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(isValidPos(row + i, col + j) && getCell(row + i, col + j).isAlive())
                    neighbors++;
            }
        }
        return neighbors;
    }
    private boolean isValidPos(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
    public Board nextGeneration() {
        Board board = new Board(rows, columns, cellType, rules);
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                for(Rule rule : rules) {
                    Cell actualCell = getCell(row, col);
                    int neighboursCant = getNeighbors(row, col);
                    if(rule.isTrue(actualCell, neighboursCant)) {
                        Cell newCell = rule.execute();
                        board.setCell(row, col, newCell);
                        break;
                    } else { //TODO: COMPLETE
                      board.setCell(row, col, actualCell);
                    }
                }
            }
        }
        return board;
    }
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                output.append(getCell(i, j).toString() + " ");
            }
            output.append("|\n");
        }
        return output.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null)
            return false;
        if(o instanceof Board board) {
            if(rows != board.rows || columns != board.columns) {
                return false;
            }
            return Arrays.deepEquals(cells, board.cells);
        }
        return false;
    }
    public static boolean checkValidStringBoard(String board) {
        int columns = 0;
        int i = 0;
        while(board.charAt(i) != '|' || board.charAt(i) != '\n') {
            columns++;
            i++;
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