package rule;

import board.Board;
import org.junit.jupiter.api.BeforeEach;
import rule.immigration.RuleBorn;

import java.util.List;

public class TestImmigrantRules {
    Board board;
    List<Rule> rules;

    @BeforeEach
    public void setUp(){
        rules.add(new rule.immigration.RuleBornRed());
        rules.add(new RuleBorn());
        rules.add(new rule.immigration.RuleStayAlive());
        rules.add(new rule.immigration.RuleDead());
    }


}
