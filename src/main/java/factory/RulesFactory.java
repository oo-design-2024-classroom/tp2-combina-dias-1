package factory;
import rule.*;
import java.util.List;
import java.util.ArrayList;

public class RulesFactory {
    public static List<Rule> factory(String rule) {
        List<Rule> rules = new ArrayList<>();
        String[] rulesSeparated = rule.split("/");
        if (rulesSeparated.length != 2)
            throw new IllegalArgumentException("Invalid input: " + rule);

        int bornRule = Integer.parseInt(rulesSeparated[0].substring(1));
        int stayAliveMin = (int) rulesSeparated[1].charAt(1);
        int stayAliveMax = (int) rulesSeparated[1].charAt(2);

        rules.add(new RuleBorn(new ArrayList<>(bornRule)));
        rules.add(new RuleDieOverpopulation(new ArrayList<>(stayAliveMax)));
        rules.add(new RuleDieUnderpopulation(new ArrayList<>(stayAliveMin)));

        ArrayList<Integer> stayAlive = new ArrayList<>();
        stayAlive.add(stayAliveMax);
        stayAlive.add(stayAliveMin);
        rules.add(new RuleStayAlive(stayAlive));

        return rules;
    }
}
