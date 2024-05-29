package observer;
import board.Board;

public class ConsoleOutput implements GameObserver {
    public void update(Board board) {
        System.out.println(board);
    }
}
