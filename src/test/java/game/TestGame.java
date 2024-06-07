package game;

import board.ClassicBoard;
import factory.board.ClassicBoardFactory;
import factory.rules.ClassicRulesFactory;
import observer.ConsoleOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.classic.ClassicRule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestGame {
    ClassicRulesFactory classicRulesFactory;
    List<ClassicRule> classicRules;

    @BeforeEach
    public void setUp(){
        classicRulesFactory = new ClassicRulesFactory();
        classicRules = classicRulesFactory.factory("B3/S23");
    }
    @Test
    public void testThreeTurns() throws InterruptedException {
        ClassicBoardFactory classicBoardFactory = new ClassicBoardFactory();
        String boardStr = "XOX\nXOX\nXOX";
        ClassicBoard classicBoard = classicBoardFactory.factory(3,3,boardStr, classicRules);
        Game game = new Game(classicBoard);
        ConsoleOutput output = new ConsoleOutput();
        game.addObserver(output);
        game.play(3);
    }
}
