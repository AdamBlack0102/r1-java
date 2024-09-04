public class LowHighSwap {
    //请实现swap方法
    public String swap(int[] array){
        int len = array.length;
        int tmp = 0;
        for(int i = 0; i < len / 2; i++){
            if(array[i] > array[len - 1 - i]){
                tmp = array[len - 1 - i];
                array[len - 1 - i] = array[i];
                array[i] = tmp;
            }
        }
        return array2String(array);
    }

    //此方法无需修改
    private String array2String(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int n:array){
            sb.append(n);
        }
        return sb.toString();
    }
}
