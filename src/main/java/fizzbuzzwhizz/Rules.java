package fizzbuzzwhizz;

import static java.util.Arrays.stream;

/**
 * Created by jxzhong on 17/1/19.
 */
public class Rules {

    public static Rule unit(Matcher matcher, Action action) {
        return (n, r) -> r.append(matcher.matches(n), action.to(n));
    }

    public static Rule any(Rule... rules) {
        return (n, r) -> stream(rules).anyMatch(rule -> rule.apply(n, r));
    }

    public static Rule and(Rule... rules) {
        return (n, r) -> {
            RuleResult result = new RuleResult();
            return r.append(match(rules, n, result), result.toString());
        };
    }

    private static boolean match(Rule[] rules, Integer n, RuleResult r) {
        return stream(rules).allMatch(rule -> rule.apply(n, r));
    }
}
