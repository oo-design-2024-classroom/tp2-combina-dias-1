import board.*;
import cell.Cell;
import cell.CellType;
import rule.*;
import observer.GameObserver;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private IBoard board;
    private List<GameObserver> observers = new ArrayList<>();

    public Game(int rows, int cols) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new RuleBorn());
        rules.add(new RuleStayAlive());
        rules.add(new RuleDieOverpopulation());
        rules.add(new RuleDieUnderpopulation());
        board = new Board(rows, cols, new Cell(CellType.DEAD), rules);
    }
    public Game(int rows, int cols, Cell cell, List<Rule> rules) {
        board = new Board(rows, cols, cell, rules);
    }
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }
    public IBoard getBoard() {
        return board;
    }
    public void setCell(int row, int col, Cell cell) {
        board.setCell(row, col, cell);
    }
    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(board);
        }
    }
    public void play(int cantGenerations) throws InterruptedException {
        for (int i = 0; i < cantGenerations; i++) {
            this.board = board.nextGeneration();
            notifyObservers();
            Thread.sleep(1000);
        }
    }
}
