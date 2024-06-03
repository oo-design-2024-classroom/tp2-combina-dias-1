package display;
import board.Board;

public class ConsoleOutput implements GameDisplay { ;
    public void update(Board board) {
        show(board.toString());
    }
    public void show(String content){
        System.out.println(content);
    }
}
