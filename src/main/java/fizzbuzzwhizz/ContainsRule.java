package fizzbuzzwhizz;

/**
 * Created by jxzhong on 2/2/16.
 */
public class ContainsRule implements Rule {

    private final Integer times;
    private final String result;

    public ContainsRule(int times, String result) {
        this.times = times;
        this.result = result;
    }

    @Override
    public boolean apply(Integer times, RuleResult ruleResult) {
        boolean isResult = times.toString().contains(this.times.toString());
        if(isResult) {
            ruleResult.append(result);
        }
        return isResult;
    }
}
