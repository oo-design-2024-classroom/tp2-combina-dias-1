package factory.rules;

import rule.Rule;

import java.util.List;

public interface IRulesFactory {
    public List<Rule> factory(String variantString);
}
