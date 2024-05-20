import cell.*;
import observer.ConsoleOutput;
import observer.GameObserver;
import org.junit.jupiter.api.Test;
import rule.*;
import java.util.ArrayList;


public class TestGame {
    @Test
    public void testThreeTurns() throws InterruptedException {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new RuleBorn());
        rules.add(new RuleStayAlive());
        rules.add(new RuleDieOverpopulation());
        rules.add(new RuleDieUnderpopulation());
        Game game = new Game(5, 5, new Cell(CellType.DEAD), rules);
        GameObserver observer = new ConsoleOutput(game.getBoard());
        game.addObserver(observer);
        game.setCell(1,2, new Cell(CellType.ALIVE));
        game.setCell(2,2, new Cell(CellType.ALIVE));
        game.setCell(3,2, new Cell(CellType.ALIVE));
        game.play(3);
    }
}
