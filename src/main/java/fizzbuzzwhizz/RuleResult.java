package fizzbuzzwhizz;

/**
 * Created by jxzhong on 2/1/16.
 */
public class RuleResult {
    private StringBuilder resultBuild;

    public RuleResult() {
        this.resultBuild = new StringBuilder();

    }

    public boolean append(Boolean ismatch, String result) {
        if (ismatch) {
            this.resultBuild.append(result);
        }
        return ismatch;
    }

    @Override
    public String toString() {
        return resultBuild.toString();
    }

    public void clear() {
        resultBuild = new StringBuilder();
    }
}
