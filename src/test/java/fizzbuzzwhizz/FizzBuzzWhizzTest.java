package fizzbuzzwhizz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 1/28/16.
 */
public class FizzBuzzWhizzTest {

    private CallCenter callCenter;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldGet_Fizz_Or_Buzz_Or_Whizz_WhenInput_3_or_5_or_7() throws Exception {

        //Given
        initailCallCenterAndRules();

        //Then
        RuleResult ruleResult = callCenter.call(3);
        assertThat(ruleResult.toString(), is("Fizz"));

        ruleResult = callCenter.call(5);
        assertThat(ruleResult.toString(), is("Buzz"));

        ruleResult = callCenter.call(14);
        assertThat(ruleResult.toString(), is("Whizz"));
    }


    @Test
    public void shouldGet_Fizz_When_Input_Contains_3() throws Exception {
        //Given
        initailCallCenterAndRules();
        RuleResult ruleResult = callCenter.call(35);

        //Then
        assertThat(ruleResult.toString(), is("Fizz"));
    }

    @Test
    public void shouldGet_Default_When_Input_not_Contains_3_and_times_of_3_5_7() throws Exception {
        //Given
        callCenter = new CallCenter();

        //When
        RuleResult ruleResult = callCenter.call(2);

        //Then
        assertThat(ruleResult.toString(), is("2"));

    }

    @Test
    public void shouldGet_FizzBuzz_When_Input_Both_3_and_5_Times() throws Exception {

        int input1 = 3;
        int input2 = 5;
        String output1 = "Fizz";
        String output2 = "Buzz";
        test_Two_AllRules_Condition(input1, input2, output1, output2);

    }

    @Test
    public void shouldGet_BuzzWhizz_When_Input_Both_5_and_7_Times() throws Exception {

        int input1 = 10;
        int input2 = 7;
        String output1 = "Buzz";
        String output2 = "Whizz";
        test_Two_AllRules_Condition(input1, input2, output1, output2);
    }


    @Test
    public void shouldGet_FizzWhizz_When_Input_Both_3_and_7_Times() throws Exception {

        int input1 = 3;
        int input2 = 7;
        String output1 = "Fizz";
        String output2 = "Whizz";
        test_Two_AllRules_Condition(input1, input2, output1, output2);

    }

    private void test_Two_AllRules_Condition(int input1, int input2, String output1, String output2) {
        //Given
        initailCallCenterAndRules();

        //When
        RuleResult ruleResult = callCenter.call(input1 * input2);

        //Then
        assertThat(ruleResult.toString(), is(String.format("%1s%2s", output1, output2)));
    }


    @Test
    public void shouldGet_FizzBuzzWhizz_When_Input_All_3_and_5_and_7_Times() {
        //Given
        initailCallCenterAndRules();
        //When
        RuleResult ruleResult = callCenter.call(3 * 5 * 7);

        //Then
        assertThat(ruleResult.toString(), is("FizzBuzzWhizz"));
    }

    private void initailCallCenterAndRules() {
        callCenter = new CallCenter();
        callCenter.initailRules();
    }
}
