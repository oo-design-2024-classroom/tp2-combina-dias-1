package factory.rules;
import rule.classic.*;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ClassicRulesFactory implements RulesFactory {
    public List<ClassicRule> factory(String ruleString) {
        List<ClassicRule> classicRules = new ArrayList<>();
        String[] rulesSeparated = ruleString.split("/");
        if (rulesSeparated.length != 2)
            throw new IllegalArgumentException("Invalid input: " + ruleString);

        List<Integer> amountNeighboursToCheckBorn = new ArrayList<>();
        List<Integer> amountNeighboursToCheckStayAlive = new ArrayList<>();

        for(String rulesSubstring : rulesSeparated) {
            if (rulesSubstring.charAt(0) == 'B') {
                amountNeighboursToCheckBorn = numberOfNeighboursToCheck(rulesSubstring);
            } else if (rulesSubstring.charAt(0) == 'S') {
                amountNeighboursToCheckStayAlive = numberOfNeighboursToCheck(rulesSubstring);
            } else throw new IllegalArgumentException("Invalid input: " + ruleString);
        }

        List<Integer> amountNeighboursToCheckDieOverpopulation = new ArrayList<>();
        List<Integer> amountNeighboursToCheckDieUnderpopulation = new ArrayList<>();

        int stayAliveMin = Collections.min(amountNeighboursToCheckStayAlive);
        amountNeighboursToCheckDieUnderpopulation.add(stayAliveMin);

        int stayAliveMax = Collections.max(amountNeighboursToCheckStayAlive);
        amountNeighboursToCheckDieOverpopulation.add(stayAliveMax);

        classicRules.add(new ClassicRuleBornClassic(amountNeighboursToCheckBorn));
        classicRules.add(new ClassicRuleDieOverpopulationClassic(amountNeighboursToCheckDieOverpopulation));
        classicRules.add(new ClassicRuleDieUnderpopulationClassic(amountNeighboursToCheckDieUnderpopulation));
        classicRules.add(new ClassicRuleStayAliveClassic(amountNeighboursToCheckStayAlive));
        return classicRules;
    }

    private static List<Integer> numberOfNeighboursToCheck(String rule) {
        if (rule.length() < 2) throw new IllegalArgumentException("Invalid input: " + rule);
        List<Integer> neighbours = new ArrayList<>();
        for(int i = 1; i < rule.length(); i++)
            neighbours.add(Character.getNumericValue(rule.charAt(i)));
        return neighbours;
    }
}