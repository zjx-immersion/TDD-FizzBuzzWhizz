package fizzbuzzwhizz;

/**
 * Created by jxzhong on 2/1/16.
 */
public class RuleResult {
    private StringBuilder resultBuild;

    public RuleResult() {
        this.resultBuild = new StringBuilder();

    }

    public void append(String result) {
        this.resultBuild.append(result);
    }


    public void append(Boolean ismatch, String result) {
        if (ismatch) {
            this.resultBuild.append(result);
        }
    }

    @Override
    public String toString() {
        return resultBuild.toString();
    }

    public void clear() {
        resultBuild = new StringBuilder();
    }
}
