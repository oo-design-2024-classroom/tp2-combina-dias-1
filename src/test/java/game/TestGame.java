package game;

import cell.*;
import factory.RulesFactory;
import observer.ConsoleOutput;
import observer.GameObserver;
import org.junit.jupiter.api.Test;
import rule.*;
import java.util.ArrayList;
import java.util.List;


public class TestGame {
    @Test
    public void testThreeTurns() throws InterruptedException {
        List<Rule> rules = RulesFactory.factory("B3/S23");
        Game game = new Game(5, 5, new Cell(CellType.DEAD), rules);
        GameObserver observer = new ConsoleOutput();
        game.addObserver(observer);
        game.setCell(1,2, new Cell(CellType.ALIVE));
        game.setCell(2,2, new Cell(CellType.ALIVE));
        game.setCell(3,2, new Cell(CellType.ALIVE));
        game.play(3);
    }
}
