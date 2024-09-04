import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class HappyNumberTest {



	@Test
	public void testSingleA() {

		assertEquals(true, HappyNumber.isHappy(19));

	}

	

	@Test
	public void testSingleB() {

		assertEquals(false, HappyNumber.isHappy(25));

	}

	

	@Test
	public void testSingleC() {

		assertEquals(true, HappyNumber.isHappy(100));

	}


	@Test
	public void testSingleD() {

		assertEquals(false, HappyNumber.isHappy(1234));

	}


	@Test
	public void testSingleE() {

		assertEquals(true, HappyNumber.isHappy(368));

	}


	

	

}