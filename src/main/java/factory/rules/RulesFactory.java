package factory.rules;
import rule.Rule;
import java.util.List;

public interface RulesFactory {
    public List<Rule> factory(String ruleString);
}
