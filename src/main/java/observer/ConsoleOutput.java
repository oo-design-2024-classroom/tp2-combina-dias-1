package observer;
import board.IBoard;

public class ConsoleOutput implements GameObserver {
    public void update(IBoard board) {
        System.out.println(board);
    }
}
