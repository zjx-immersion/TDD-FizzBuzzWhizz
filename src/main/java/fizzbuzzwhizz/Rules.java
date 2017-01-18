package fizzbuzzwhizz;

import java.util.Arrays;

import static java.util.Arrays.asList;

/**
 * Created by jxzhong on 17/1/19.
 */
public class Rules {

    public static Rule timeRule(Integer number, String result) {
        return (n, r) -> {
            boolean isMatch = n % number == 0;
            r.append(isMatch, result);
            return isMatch;
        };
    }

    public static Rule containRule(Integer number, String result) {
        return (n, r) -> {
            boolean isMatch = n.toString().contains(number.toString());
            r.append(isMatch, result);
            return isMatch;
        };
    }

    public static Rule defaultRule() {
        return (n, r) -> {
            boolean ismatch = true;
            r.append(ismatch, n.toString());
            return ismatch;
        };
    }

    public static Rule anyRule(Rule... rules) {
        return (n, r) -> asList(rules).stream().anyMatch(rule -> rule.apply(n, r));
    }

    public static Rule andRule(Rule... rules) {
        return (n, r) -> {
            RuleResult result = new RuleResult();
            boolean isMatch = match(rules, n, result);
            r.append(isMatch, result.toString());

            return isMatch;
        };
    }

    private static boolean match(Rule[] rules, Integer times, RuleResult ruleResult) {
        return Arrays.stream(rules).allMatch(rule -> rule.apply(times, ruleResult));
    }
}
