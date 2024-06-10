package factory.board;

import board.*;
import rule.Rule;
import java.util.List;

public interface BoardFactory {
    public Board factory(int rows, int columns, String board, List<Rule> rules);
}
