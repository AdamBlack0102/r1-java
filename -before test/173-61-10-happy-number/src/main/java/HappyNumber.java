
public class HappyNumber {
    public static int[] toArray(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        return arr;
    }

    public static boolean isHappy(int n) {
        int[] arr = toArray(n);
        int len = arr.length;
        int sum = 0;
        for(int i = 0; i < 1001; i++) {
            len = arr.length;
            for(int j = 0; j < len; j++) {
                sum += arr[j] * arr[j];
            }
            if(sum == 1) {
                return true;
            }
            arr = toArray(sum);
            sum = 0;
        }
        return false;
    }
}
