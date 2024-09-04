
import static org.junit.Assert.*;

import org.junit.Test;

public class RepeatedSubstringPatternTest {

	@Test
	public void testRepeatedSubstringPatternA() {
		assertEquals(true, RepeatedSubstringPattern.repeatedSubstringPattern("abcabcabc"));
	}
	
	@Test
	public void testRepeatedSubstringPatternB() {
		assertEquals(false, RepeatedSubstringPattern.repeatedSubstringPattern("abca"));
	}
	
	@Test
	public void testRepeatedSubstringPatternC() {
		assertEquals(true, RepeatedSubstringPattern.repeatedSubstringPattern("abab"));
	}
	
}
