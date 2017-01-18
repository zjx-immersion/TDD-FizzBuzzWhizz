package fizzbuzzwhizz;

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

        TimesRule r1 = new TimesRule(3, "Fizz");
        TimesRule r2 = new TimesRule(5, "Buzz");
        TimesRule r3 = new TimesRule(7, "Whizz");

        Rule all1 = new AndRule(r1, r2, r3);
        Rule all3 = new AndRule(r1, r3);
        Rule all2 = new AndRule(r1, r2);
        Rule all4 = new AndRule(r2, r3);

        Rule rc = new ContainsRule(3, "Fizz");

        Rule rd = new DefaultRule();

        AnyRule anyRule = new AnyRule(rc, all1, all2, all3, all4, r1, r2, r3, rd);

        return anyRule;

    }
}
