package observer;

import board.IBoard;

public interface GameObserver {
    public void update(IBoard board);
}
