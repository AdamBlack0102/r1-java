
public class RepeatedSubstringPattern {

	public static boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		for(int i = 0; i < len - 1; i++) {
			String substr = str.substring(0, i + 1);
			String remainstr = str.substring(i + 1);
			if(remainstr.startsWith(substr)) {
				return true;
			}
		}
    	return false;
    }
}