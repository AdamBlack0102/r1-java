/*
import java.util.*;

public class KthLargestElement {
	 public static int findKthLargest(int[] nums, int k) {
		 Scanner sc = new Scanner(System.in);
		 String s = sc.nextLine();
		 char[] ch = s.toCharArray();
		 int n = sc.nextInt();

		 Arrays.sort(ch);

		 int len = ch.length;
		 int max = len - n;

		 System.out.println(ch[max]);
	     return 0;
	 }
}
*/
import java.util.Arrays;

public class KthLargestElement {
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums); // 先对数组进行排序
		return nums[nums.length - k]; // 返回第 k 大的数
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1};
		int k = 1;
		int result = findKthLargest(nums, k);
		System.out.println(result);
	}
}
