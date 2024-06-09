package factory;
import factory.rules.RulesFactory;
import org.junit.jupiter.api.Test;
import rule.classic.ClassicRule;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClassicIRulesFactory {
    @Test
    public void testRules() {
        RulesFactory rulesFactory = new RulesFactory();
        List<ClassicRule> classicRules = rulesFactory.factory("B2/S23");
        List<Integer> tempList = new ArrayList<>();
        tempList.add(2);
        assertThat(classicRules.get(0).getNeighboursToCheck()).isEqualTo(tempList);
        assertThat(classicRules.get(2).getNeighboursToCheck()).isEqualTo(tempList);
        tempList.add(3);
        assertThat(classicRules.get(1).getNeighboursToCheck().get(0)).isEqualTo(tempList.get(1));
        assertThat(classicRules.get(3).getNeighboursToCheck()).isEqualTo(tempList);
    }
     @Test
    public void testInvalidRules() {
         RulesFactory rulesFactory = new RulesFactory();
         IllegalArgumentException  exception = assertThrows(IllegalArgumentException.class,
                 () -> {
                     List<ClassicRule> classicRules = rulesFactory.factory("2S23");

                 });
         assertThat(exception.getMessage().equals("Illegal rule"));
     }
}
