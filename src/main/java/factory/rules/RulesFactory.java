package factory.rules;

import rule.Rule;
import rule.briansBrain.*;
import rule.classic.*;
import rule.immigration.RuleBorn;
import rule.immigration.RuleStayAlive;
import rule.starwars.RuleState0;
import rule.starwars.RuleState1;
import rule.starwars.RuleState2;
import rule.starwars.RuleState3;

import java.util.ArrayList;
import java.util.List;

public class RulesFactory implements IRulesFactory {
    @Override
    public List<Rule> factory(String variantString) {
        List<Rule> rules = new ArrayList<>();
        switch(variantString){
            case "classic":
                rules.add(new RuleAliveClassic());
                rules.add(new RuleDeadClassic());
                return rules;
            case "briansBrain":
                rules.add(new RuleAlive());
                rules.add(new RuleSemiDead());
                rules.add(new RuleDead());
                return rules;
            case "starWars":
                rules.add(new RuleState0());
                rules.add(new RuleState1());
                rules.add(new RuleState2());
                rules.add(new RuleState3());
                return rules;
            case "immigration":
                rules.add(new RuleBorn());
                rules.add(new RuleBornRed());
                rules.add(new rule.immigration.RuleDead());
                rules.add(new RuleStayAlive());
                return rules;
            case "quadlife":
                rules.add(new rule.quadlife.RuleBorn());
                rules.add(new rule.quadlife.RuleDead());
                rules.add(new rule.quadlife.RuleStayAlive());
                return rules;
            default:
                throw new IllegalArgumentException("Invalid variant");
        }
    }
}