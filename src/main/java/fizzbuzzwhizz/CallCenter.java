package fizzbuzzwhizz;

import static fizzbuzzwhizz.Action.nop;
import static fizzbuzzwhizz.Action.to;
import static fizzbuzzwhizz.Matcher.always;
import static fizzbuzzwhizz.Matcher.contains;
import static fizzbuzzwhizz.Matcher.is;
import static fizzbuzzwhizz.Rules.*;

/**
 * Created by jxzhong on 1/28/16.
 */
public class CallCenter {


    public RuleResult call(Integer number) {
        RuleResult ruleResult = new RuleResult();
        initailRules().apply(number, ruleResult);
        return ruleResult;
    }


    public Rule initailRules() {

        Rule r1 = unit(is(3), to("Fizz"));
        Rule r2 = unit(is(5), to("Buzz"));
        Rule r3 = unit(is(7), to("Whizz"));

        Rule all1 = and(r1, r2, r3);
        Rule all3 = and(r1, r3);
        Rule all2 = and(r1, r2);
        Rule all4 = and(r2, r3);

        Rule rc = unit(contains(3), to("Fizz"));

        Rule rd = unit(always(true), nop());

        Rule anyRule = any(rc, all1, all2, all3, all4, r1, r2, r3, rd);

        return anyRule;

    }
}
