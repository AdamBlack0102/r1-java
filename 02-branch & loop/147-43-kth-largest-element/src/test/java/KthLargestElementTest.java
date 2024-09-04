import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KthLargestElementTest {
	@Test
	public void testA() {
		assertEquals(5, KthLargestElement.findKthLargest(new int[]{1, 2, 3, 4, 5, 6}, 2));
	}
}