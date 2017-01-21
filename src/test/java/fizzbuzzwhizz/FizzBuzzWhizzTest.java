package fizzbuzzwhizz;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.junit.Before;
import org.junit.Test;

import static java.lang.String.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 1/28/16.
 */
public class FizzBuzzWhizzTest {

    private CallCenter callCenter;

    @Before
    public void setUp() throws Exception {
        callCenter = initailCallCenterAndRules();
    }

    @Test
    public void shouldGet_Fizz_Or_Buzz_Or_Whizz_WhenInput_3_or_5_or_7() throws Exception {

        //When
        int number3 = 3;
        int number5 = 5;
        int number7 = 7;

        //Then
        assertThat(valueOf(callCenter.call(number3)), is("Fizz"));

        assertThat(valueOf(callCenter.call(number5)), is("Buzz"));

        assertThat(valueOf(callCenter.call(number7)), is("Whizz"));
    }


    @Test
    public void shouldGet_Fizz_When_Input_Contains_3() throws Exception {
        //When
        int number = 35;

        //Then
        assertThat(valueOf(callCenter.call(number)), is("Fizz"));
    }

    @Test
    public void shouldGet_Default_When_Input_not_Contains_3_and_times_of_3_5_7() throws Exception {
        //When
        int number = 2;

        //Then
        assertThat(valueOf(callCenter.call(number)), is("2"));

    }

    @Test
    public void shouldGet_FizzBuzz_When_Input_Both_3_and_5_Times() throws Exception {

        //When
        int input1 = 3;
        int input2 = 5;
        String output1 = "Fizz";
        String output2 = "Buzz";
        //Then
        test_Two_AllRules_Condition(input1, input2, output1, output2);

    }

    @Test
    public void shouldGet_BuzzWhizz_When_Input_Both_5_and_7_Times() throws Exception {

        //When
        int input1 = 10;
        int input2 = 7;
        String output1 = "Buzz";
        String output2 = "Whizz";
        //Then
        test_Two_AllRules_Condition(input1, input2, output1, output2);
    }


    @Test
    public void shouldGet_FizzWhizz_When_Input_Both_3_and_7_Times() throws Exception {
        //When
        int input1 = 3;
        int input2 = 7;
        String output1 = "Fizz";
        String output2 = "Whizz";
        //Then
        test_Two_AllRules_Condition(input1, input2, output1, output2);

    }

    private void test_Two_AllRules_Condition(int input1, int input2, String output1, String output2) {
        //When
        int number = input1 * input2;

        //Then
        assertThat(valueOf(callCenter.call(number)), is(String.format("%1s%2s", output1, output2)));
    }


    @Test
    public void shouldGet_FizzBuzzWhizz_When_Input_All_3_and_5_and_7_Times() {

        //When
        int number = 3 * 5 * 7;

        //Then
        assertThat(valueOf(callCenter.call(number)), is("FizzBuzzWhizz"));
    }

    private CallCenter initailCallCenterAndRules() {
        CallCenter callCenter = new CallCenter();
        callCenter.initailRules();
        return callCenter;
    }
}
