package display;

import board.Board;

import java.io.IOException;

public interface GameDisplay {
    public void update(Board board) throws IOException;
    public void show(String content);
}
