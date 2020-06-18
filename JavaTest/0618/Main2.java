package Practice_0618;

public class Main2 {

    private static String[] sort (String[] arr1){
        int mid = arr1.length/2-1;
        String[] s1 = subArray(0,mid,arr1);
        String[] s2 = subArray(mid+1,arr1.length-1,arr1);
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < s1.length; i++) {
            stringBuilder.append(s1[i] + " ");
            stringBuilder.append(s2[i] + " ");
        }
        return stringBuilder.toString().split("");
    }
    private static String[] subArray(int head, int tail, String[] arr){
        String[] res = new String[tail-head + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[head];
            head++;
        }
        return res;
    }
    private static String[] deleteArr(int tail, String[] arr){
        String[] newArray = new String[arr.length - tail - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arr[++tail];
        }
        return newArray;
    }

    public static void main(String[] args) {
        String[] arr = {"1","2","3","4","5","6"};
        String[] res = sort(arr);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
    }
}
