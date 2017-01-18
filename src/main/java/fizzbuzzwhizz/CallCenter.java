package fizzbuzzwhizz;

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

        Rule r1 = timeRule(3, "Fizz");
        Rule r2 = timeRule(5, "Buzz");
        Rule r3 = timeRule(7, "Whizz");

        Rule all1 = andRule(r1, r2, r3);
        Rule all3 = andRule(r1, r3);
        Rule all2 = andRule(r1, r2);
        Rule all4 = andRule(r2, r3);

        Rule rc = containRule(3, "Fizz");

        Rule rd = defaultRule();

        Rule anyRule = anyRule(rc, all1, all2, all3, all4, r1, r2, r3, rd);

        return anyRule;

    }
}
