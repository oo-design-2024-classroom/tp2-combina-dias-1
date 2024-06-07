package factory.rules;
import rule.classic.ClassicRule;

import java.util.List;

public interface RulesFactory {
    public List<ClassicRule> factory(String ruleString);
}
