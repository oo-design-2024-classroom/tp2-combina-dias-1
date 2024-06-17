package factory;
import org.junit.jupiter.api.Test;
import rule.classic.*;
import rule.briansBrain.*;
import rule.immigration.*;
import rule.quadlife.*;
import rule.starwars.*;
import rule.Rule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;  // For better list comparison

public class TestRulesFactory {

    private RulesFactory rulesFactory = new RulesFactory();

    @Test
    public void testClassicRules() {
        List<Rule> rules = rulesFactory.factory("classic");

        assertThat(rules).hasSize(2);
        assertInstanceOf(RuleAliveClassic.class, rules.get(0));
        assertInstanceOf(RuleDeadClassic.class, rules.get(1));
    }

    @Test
    public void testBriansBrainRules() {
        List<Rule> rules = rulesFactory.factory("briansBrain");
        assertThat(rules).hasSize(3);
        assertInstanceOf(RuleAliveBB.class, rules.get(0));
        assertInstanceOf(RuleSemiDead.class, rules.get(1));
        assertInstanceOf(RuleDeadBB.class, rules.get(2));
    }

    @Test
    public void testStarWarsRules() {
        List<Rule> rules = rulesFactory.factory("starWars");
        assertThat(rules).hasSize(3);
        assertInstanceOf(RuleState0.class, rules.get(0));
        assertInstanceOf(RuleState1.class, rules.get(1));
        assertInstanceOf(RuleState2.class, rules.get(2));
    }

    @Test
    public void testImmigrationRules() {
        List<Rule> rules = rulesFactory.factory("immigration");
        assertThat(rules).hasSize(3);
        assertInstanceOf(RuleBornImmigration.class, rules.get(0));
        assertInstanceOf(RuleDeadImmigration.class, rules.get(1));
        assertInstanceOf(RuleStayAliveImmigration.class, rules.get(2));
    }

    @Test
    public void testQuadLifeRules() {
        List<Rule> rules = rulesFactory.factory("quadlife");
        assertThat(rules).hasSize(3);
        assertInstanceOf(RuleBornQuadlife.class, rules.get(0));
        assertInstanceOf(RuleDeadQuadlife.class, rules.get(1));
        assertInstanceOf(RuleStayAliveQuadlife.class, rules.get(2));
    }

    @Test
    public void testInvalidVariant() {
        assertThrows(IllegalArgumentException.class, () -> rulesFactory.factory("invalidVariant"));
    }
}
