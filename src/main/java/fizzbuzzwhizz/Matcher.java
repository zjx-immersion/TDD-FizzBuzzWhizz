package fizzbuzzwhizz;

import static java.lang.String.valueOf;

/**
 * Created by jxzhong on 17/1/19.
 */
public interface Matcher {
    boolean matches(Integer n);

    static Matcher is(Integer number) {
        return n -> n % number == 0;
    }

    static Matcher contains(Integer number) {
        return n -> valueOf(n).contains(valueOf(number));
    }

    static Matcher always(boolean isMatch) {
        return n -> isMatch;
    }
}
