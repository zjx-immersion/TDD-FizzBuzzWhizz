package fizzbuzzwhizz;

import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static java.util.Arrays.asList;

/**
 * Created by jxzhong on 17/1/19.
 */
public class AnyRule implements Rule {

    private List<Rule> rules = new ArrayList();

    public AnyRule(Rule... rules) {
        this.rules = asList(rules);
    }


    @Override
    public boolean apply(Integer number, RuleResult ruleResult) {
        return from(rules).anyMatch(new Predicate<Rule>() {
            @Override
            public boolean apply(Rule rule) {
                return rule.apply(number, ruleResult);
            }
        });

    }
}
