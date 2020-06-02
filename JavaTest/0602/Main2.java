package Practice_0602;


public class Main2 {
    public  int count(int[] A, int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(A[i] > A[j]){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,0};
        int n = 8;

    }
}
