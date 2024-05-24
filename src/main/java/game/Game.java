package game;

import board.*;
import cell.Cell;
import factory.CellFactory;
import rule.*;
import observer.GameObserver;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private IBoard board;
    private List<GameObserver> observers = new ArrayList<>();

    public Game(int rows, int cols, List<Rule> rules) {
        board = new Board(rows, cols, rules);
    }
    public Game(IBoard board) {
        this.board = board;
    }
    public void addObserver(GameObserver observer) {
        observers.add(observer);
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
    IBoard getBoard(){
        return board;
    }
}
