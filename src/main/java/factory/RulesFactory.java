package factory;

import rule.Rule;
import rule.briansBrain.*;
import rule.classic.*;
import rule.immigration.RuleBornImmigration;
import rule.immigration.RuleDeadImmigration;
import rule.immigration.RuleStayAliveImmigration;
import rule.quadlife.RuleBornQuadlife;
import rule.quadlife.RuleDeadQuadlife;
import rule.quadlife.RuleStayAliveQuadlife;
import rule.starwars.RuleState0;
import rule.starwars.RuleState1;
import rule.starwars.RuleState2;
import rule.starwars.RuleState3;

import java.util.ArrayList;
import java.util.List;

public class RulesFactory {
    public List<Rule> factory(String variantString) {
        List<Rule> rules = new ArrayList<>();
        switch(variantString){
            case "classic":
                rules.add(new RuleAliveClassic());
                rules.add(new RuleDeadClassic());
                return rules;
            case "briansBrain":
                rules.add(new RuleAliveBB());
                rules.add(new RuleSemiDead());
                rules.add(new RuleDeadBB());
                return rules;
            case "starWars":
                rules.add(new RuleState0());
                rules.add(new RuleState1());
                rules.add(new RuleState2());
                rules.add(new RuleState3());
                return rules;
            case "immigration":
                rules.add(new RuleBornImmigration());
                rules.add(new RuleDeadImmigration());
                rules.add(new RuleStayAliveImmigration());
                return rules;
            case "quadlife":
                rules.add(new RuleBornQuadlife());
                rules.add(new RuleDeadQuadlife());
                rules.add(new RuleStayAliveQuadlife());
                return rules;
            default:
                throw new IllegalArgumentException("Invalid variant");
        }
    }
}