package fizzbuzzwhizz;
/**
 * Created by jxzhong on 2/1/16.
 */
public class TimesRule implements Rule {

    private final int times;
    private final String result;

    public TimesRule(int times, String result) {
        this.times = times;
        this.result = result;
    }

    public boolean apply(Integer times, RuleResult ruleResult) {
//        ruleResult = new RuleResult();
        boolean isResult = times % this.times == 0;
        if(isResult) {
            ruleResult.append(result);
        }
        return isResult;
    }
}
