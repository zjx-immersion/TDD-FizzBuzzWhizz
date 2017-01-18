package fizzbuzzwhizz;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by jxzhong on 17/1/17.
 */
public class AndRule implements Rule {
    private final Rule[] rules;

    public AndRule(TimesRule... rules) {
        this.rules = rules;
    }

    @Override
    public boolean apply(Integer times, RuleResult ruleResult) {
        RuleResult result = new RuleResult();
        boolean isMatch = match(times, result);
        ruleResult.append(isMatch, result.toString());

        return isMatch;
    }

    private boolean match(final Integer times, final RuleResult ruleResult) {
        return Arrays.asList(rules).stream().allMatch(new Predicate<Rule>() {
            @Override
            public boolean test(Rule rule) {
                return rule.apply(times, ruleResult);
            }
        });
    }
}
