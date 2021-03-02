package labs_examples.lambdas.labs;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */

public class Exercise_02 {
    public static void main(String[] args) {

        //1 - Predicate
        Predicate<Integer> isOdd = integer -> (integer % 2 != 0);
        System.out.println(isOdd.test(5));

        //2 - Function
        Function<String, Double> thirdOfLength = s -> ((double) s.length() / 3);
        System.out.println(thirdOfLength.apply("I Love Rock And Roll"));

        //3 - BiFunction

        BiFunction<String, String, String> fullName = (firstName, lastName) -> (firstName + " " + lastName);
        String first = "Efim";
        String last = "Shulgin";
        System.out.println(fullName.apply(first, last));

        //4 - Supplier
        //Reference: https://mkyong.com/java8/java-8-supplier-examples/

        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        LocalDateTime time = supplier.get();

        System.out.println(time);

        //5 - Consumer

        ArrayList<Integer> leapYears = new ArrayList<>();
        leapYears.add(2020);
        leapYears.add(2016);
        leapYears.add(2012);

        leapYears.forEach((year) -> System.out.println(year + " was a leap year"));

        //6 - Double to Int

        DoubleToIntFunction weight = d -> ((int) Math.floor(d));
        System.out.println(weight.applyAsInt(127.56));

        //7 - Double Predicate

        DoublePredicate isLessThanMillion = d -> (d < 1000000);
        System.out.println(isLessThanMillion.test(5000000.54542));

        //8 - BiPredicate

        BiPredicate<String, Integer> hasLengthOf = (string, length) -> (string.length() == length);
        System.out.println(hasLengthOf.test("efim", 4));

        //9 - UnaryOperator
        //Reference : https://www.youtube.com/watch?v=ov63LS-LXBA

        List<Integer> nums = Arrays.asList(54, 34, 21, 67);
        UnaryOperator<Integer> unaryOperator = i -> i*i;
        unOpFunction(unaryOperator, nums).forEach(i -> System.out.println(i));

        //10 - LongBinaryOperator

        LongBinaryOperator divideSumBySixtySeven = (long1, long2) -> ((long1 + long2) / 67);
        System.out.println(divideSumBySixtySeven.applyAsLong(5634334, 43435345));



    }

    private static List<Integer> unOpFunction(UnaryOperator<Integer> unaryOperator, List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        nums.forEach(i -> list.add(unaryOperator.apply(i)));
        return list;
    }
}