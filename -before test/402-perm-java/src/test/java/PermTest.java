
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermTest {
    private final Perm perm = new Perm();

    @Test
    public void test1() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expect = {1, 2, 3, 5, 4};

        List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> expectList = Arrays.stream(expect).boxed().collect(Collectors.toList());

        perm.nextPermutation(inputList);

        assertEquals(inputList, expectList);
    }

    @Test
    public void test5() {
        int[] input = {3, 1, 2, 5, 4};
        int[] expect = {3, 1, 4, 2, 5};

        List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> expectList = Arrays.stream(expect).boxed().collect(Collectors.toList());

        perm.nextPermutation(inputList);

        assertEquals(inputList, expectList);
    }

    @Test
    public void test10() {
        int[] input = {3, 1, 2};
        int[] expect = {3, 2, 1};

        List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> expectList = Arrays.stream(expect).boxed().collect(Collectors.toList());

        perm.nextPermutation(inputList);

        assertEquals(inputList, expectList);
    }

    @Test
    public void test15() {
        int[] input = {4, 5, 3, 2, 1, 6};
        int[] expect = {4, 5, 3, 2, 6, 1};

        List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> expectList = Arrays.stream(expect).boxed().collect(Collectors.toList());

        perm.nextPermutation(inputList);

        assertEquals(inputList, expectList);
    }

    @Test
    public void test20() {
        int[] input = {8, 7, 6, 5, 4, 3, 1, 2};
        int[] expect = {8, 7, 6, 5, 4, 3, 2, 1};

        List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> expectList = Arrays.stream(expect).boxed().collect(Collectors.toList());

        perm.nextPermutation(inputList);

        assertEquals(inputList, expectList);
    }
}