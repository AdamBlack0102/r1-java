import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CheckOddEvenTest {
	@Test

	public void testSingleA() {

		assertEquals(false, CheckOddEven.isOdd(0));

	}

	

	@Test

	public void testSingleB() {

		assertEquals(true, CheckOddEven.isOdd(3));

	}

	

	@Test

	public void testSingleC() {

		assertEquals(false, CheckOddEven.isOdd(12));

	}

}
