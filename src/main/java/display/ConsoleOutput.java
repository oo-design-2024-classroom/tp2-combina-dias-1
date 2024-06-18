package display;
import board.IBoard;

public class ConsoleOutput implements GameDisplay {
    public void update(IBoard board) {
        show(board.toString());
    }
    public void show(String content){
        System.out.println(content);
    }
}
