package fizzbuzzwhizz;
/**
 * Created by jxzhong on 17/1/17.
 */
public class DefaultRule implements Rule {
    @Override
    public boolean apply(Integer times, RuleResult ruleResult) {
        ruleResult.append(times.toString());
        return true;
    }
}
