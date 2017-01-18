package fizzbuzzwhizz;

import static java.lang.String.valueOf;

/**
 * Created by jxzhong on 17/1/19.
 */
public interface Action {
    String to(Integer n);

    static Action to(String result) {
        return n -> result;
    }

    static Action nop() {
        return n -> valueOf(n);
    }

}
