package display;

import board.IBoard;

import java.io.IOException;

public interface GameDisplay {
    public void update(IBoard board) throws IOException;
    public void show(String content) throws IOException;
}
