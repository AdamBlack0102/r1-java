import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowHighSwapTest {
    private final LowHighSwap lowHighSwap = new LowHighSwap();

    @Test
    public void test1(){
        int[] array = new int[]{5,3,4,2,1};
        assertEquals("12435",lowHighSwap.swap(array));
    }

    @Test
    public void test2(){
        int[] array = new int[]{1,3,4,6,2,1};
        assertEquals("124631",lowHighSwap.swap(array));
    }

    @Test
    public void test3(){
        int[] array = new int[]{8,7,6,5,4,3,2,1};
        assertEquals("12345678",lowHighSwap.swap(array));
    }
}
