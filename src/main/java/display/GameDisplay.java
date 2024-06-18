package display;

import board.IBoard;

import java.io.IOException;

public interface GameDisplay {
    void update(IBoard board) throws IOException;
    void show(String content) throws IOException;
}
