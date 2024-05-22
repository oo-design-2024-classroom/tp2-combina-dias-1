package factory;
import org.junit.jupiter.api.Test;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRulesFactory {
    @Test
    public void testRules() {
        RulesFactory rulesFactory = new RulesFactory();
        List<Rule> rules = rulesFactory.factory("B2/S23");
        List<Integer> tempList = new ArrayList<>();
        tempList.add(2);
        assertThat(rules.get(0).getNeighboursToCheck()).isEqualTo(tempList);
        assertThat(rules.get(2).getNeighboursToCheck()).isEqualTo(tempList);
        tempList.add(3);
        assertThat(rules.get(1).getNeighboursToCheck().get(0)).isEqualTo(tempList.get(1));
        assertThat(rules.get(3).getNeighboursToCheck()).isEqualTo(tempList);
    }
     @Test
    public void testInvalidRules() {
         RulesFactory rulesFactory = new RulesFactory();
         IllegalArgumentException  exception = assertThrows(IllegalArgumentException.class,
                 () -> {
                     List<Rule> rules = rulesFactory.factory("2S23");

                 });
         assertThat(exception.getMessage().equals("Illegal rule"));
     }
}
