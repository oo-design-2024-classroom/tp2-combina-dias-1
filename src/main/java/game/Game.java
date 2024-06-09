package game;

import board.*;
import cell.ClassicCell;
import observer.GameObserver;
import rule.classic.ClassicRule;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<GameObserver> observers = new ArrayList<>();

    public Game(int rows, int cols, List<ClassicRule> classicRules) {
        board = new ClassicBoard(rows, cols, classicRules);
    }
    public Game(ClassicBoard board) {
        this.board = board;
    }
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }
    public void setCell(int row, int col, ClassicCell classicCell) {
        board.setCell(row, col, classicCell);
    }
    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(board);
        }
    }
    public void play() throws InterruptedException {
        for (int i = 0; i < cantGenerations; i++) {
            this.board = board.nextGeneration();
            notifyObservers();
            Thread.sleep(1000);
        }
    }
    Board getBoard(){
        return board;
    }
}
