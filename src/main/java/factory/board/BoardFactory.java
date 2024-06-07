package factory.board;

import board.*;
import rule.classic.ClassicRule;

import java.util.List;

public interface BoardFactory {
    public Board factory(int rows, int columns, String board, List<ClassicRule> classicRules);
    public boolean checkValidStringBoard(String board);
}
