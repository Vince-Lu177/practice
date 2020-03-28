//1、递归求 N 的阶乘
import java.util.Scanner;
public class Test {
    public static int fact(int n){
        if(n == 1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        System.out.println("请输入n：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = fact(n);
        System.out.println("res"+res);
    }
}

//2、递归求 1 + 2 + 3 + ... + 10
//public class Test{
//    public static int sum (int num){
//        if(num == 1){
//            return 1;
//        }
//        return num + sum( num - 1);
//    }
//    public static void main(String[] args) {
//        System.out.println(sum(10));
//    }
//}
//
//3、按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
//public class Test{
//    public static void Print(int num){
//        if(num > 9){
//            Print(num / 10);
//        }
//        System.out.println(num % 10);
//    }
//    public static void main(String[] args) {
//        Print(1234);
//    }
//}
//
//4、写一个递归方法，输入一个非负整数，返回组成它的数字之和.
//public  class  Test{
//    public static int sum(int num){
//        if(num<10){
//            return num;
//        }
//        return num % 10 + sum(num / 10);
//    }
//    public static void main(String[] args) {
//        System.out.println(sum(9527));
//    }
//}
//
//5、递归求斐波那契数列的第 N 项
//import java.util.Scanner;
//public class Test{
//    public static int fib(int num){
//        if((num == 1) || (num == 2)){
//            return 1;
//        }
//        return fib(num - 1) + fib(num - 2);
//    }
//    public static void main(String[] args) {
//        System.out.println("请输入n：");
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println(fib(n));
//    }
//}
//
//6、递归求解汉诺塔问题
// 汉诺塔问题是一个经典的问题。汉诺塔（Hanoi Tower），又称河内塔，源于印度一个古老传说。
// 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
// 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
// 并且规定，任何时候，在小圆盘上都不能放大圆盘，且在三根柱子之间一次只能移动一个圆盘。 问应该如何操作？
//import java.util.Scanner;
//public class Test{
//    public  static void move(char x,char y){
//        System.out.println(x + "->" + y);
//    }
//    public static void Hanoi(int n,char one,char two,char three){
//        if(n == 1){
//            move(one,three);
//        }else {
//            Hanoi(n - 1, one,three,two);//通过C从A移动到B，移动n-1个盘子
//            move(one, three);
//            Hanoi(n - 1,two,one,three);//最后通过A从B移动到C，移动n-1个盘子
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println("请输入你所需要移动的盘数：");
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println("移动的具体步骤如下：");
//        Hanoi(n,'A','B','C');
//    }
//}
//
//7、递归实现代码: 青蛙跳台阶问题
//一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个n 级的台阶总共有多少种跳法?
//import java.util.Scanner;
//public class Test{
//    public static int getJumpNum(int n){
//        if(n < 0 ){
//            return 0;
//        }else if(n == 1){
//            return 1;
//        }else if(n == 2){
//            return 2;
//        }
//        return getJumpNum(n - 1) + getJumpNum(n - 2);
//    }
//    public static void main(String[] args) {
//        System.out.println("请输入台阶数");
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println("共有" + getJumpNum(n) + "跳法");
//    }
//}
//
//1.编写代码: 创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
//public class Test{
//    public static void main(String[] args) {
//        int[] arr = new int [100];
//        for(int i = 0;i < arr. length;i++){
//            arr[i] = i + 1;
//        }
//        for(int x:arr){
//            System.out.print(x + " ");
//        }
//    }
//}
//
//2.编写代码: 实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
//public class Test{
//    public static void printArray(int[] arr){
//        for(int x:arr){
//            System.out.print(x + " ");
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4};
//        printArray(arr);
//    }
//}
//
//3.编写代码: 实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
// 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
//public class Test{
//    public static void transform(int[] arr){
//        for(int i = 0;i < arr.length;i++){
//            arr[i] *=2;
//        }
//        for(int x:arr){
//            System.out.printl(x + " ");
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        transform(arr);
//    }
//}
//
//4.编写代码: 实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
//public class Test{
//    public static void sum(int[] arr){
//        int res = 0;
//        for(int i = 0;i < arr.length;i++){
//            res += arr[i];
//        }
//        System.out.println(res);
//    }
//    public static void main(String[] args){
//        int[] arr = {1,3,5,7,9};
//        sum(arr);
//    }
//}
//
//5.编写代码: 实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
//public class Test{
//    public static double avg(int[] arr){
//        int res = 0;
//        for(int i = 0;i < arr.length;i++){
//            res += arr[i];
//        }
//        return (double) (res / arr.length);
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,3,5,7,9};
//        System.out.println((avg(arr)));
//    }
//}
//
//1.实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
//public class Test{
//    public static String toString(int[] arr){
//        String res = "[";
//        for(int i = 0;i < arr.length;i++){
//            res += arr[i];
//            if(i != arr.length - 1) {
//                res += ",";
//            }
//        }
//        res += "]";
//        return res;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        System.out.println(toString(arr));
//    }
//}
//
//2.实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
//public class Test{
//    public static void copyOf(int[] arr){
//        int[] a = new int[arr.length];
//        for(int i = 0;i < arr.length;i++){
//            a[i] = arr[i];
//        }
//        for(int x:a){
//            System.out.print(x + " ");
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr ={1,2,3,4,5};
//        copyOf(arr);
//    }
//}
//
//3.给定一个有序整型数组, 实现二分查找
//public class Test{
//    public  static int binarySearch(int[] arr,int toFind){
//        int left = 0;
//        int right =arr.length - 1;
//        while(left <= right){
//            int mid = (left + right) >> 1;
//            if(toFind < arr[mid]) {
//                right = mid - 1;
//            }else if(toFind > arr[mid]){
//                left = mid + 1;
//            }else {
//                return mid;
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int toFind = 6;
//        System.out.println(binarySearch(arr, toFind));
//    }
//}
//
//4.给定一个整型数组, 判定数组是否有序
//public class Test{
//    public static boolean isOrder(int[] arr){
//        for(int i = 0;i < arr.length - 1;i++){
//            if(arr[i] > arr [i + 1]){
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(isOrder(arr));
//    }
//}
//
//5.给定一个整型数组, 实现冒泡排序(升序排序)
//public class Test{
//    public static void bubblesort(int[] arr){
//        for(int bound = 0;bound < arr.length;bound++){
//            for(int cur = arr.length - 1;cur > bound;cur--){
//                if(arr[cur - 1] > arr[cur]){
//                    int temp = arr[cur - 1];
//                    arr[cur - 1] = arr[cur];
//                    arr[cur] = temp;
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = {1, 6, 4, 5, 2, 8, 7};
//        bubblesort(arr);
//        for (int x : arr) {
//            System.out.printf(x + " ");
//        }
//    }
//}

//1.数组转字符串
//public class Test {
//    public static String toString(int[] arr) {
//        String ret = "[";
//        for (int i = 0; i < arr.length; i++) {
//            ret += arr[i];
//            if(i != arr.length - 1){
//                ret += ",";
//            }
//        }
//        ret += "]";
//        return ret;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(toString(arr));
//    }
//}

//2.数组拷贝
//import  java.util.Arrays;
//public class Test{
//    public static int[] copyArr (int[] arr){
//        int[] ret = new int[arr.length];
//        for(int i = 0;i < arr.length;i++){
//            ret[i] = arr[i];
//        }
//        return ret;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        int[] newArr = copyArr(arr);
//        System.out.println(Arrays.toString(newArr));
//    }
//}

//3.找出数组中的最大值
//public class Test{
//    public static int max(int[] arr){
//        int max = arr[0];
//        for(int i = 0;i < arr.length;i++){
//            if(max < arr[i]){
//                max = arr[i];
//            }
//        }
//        return max;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(max(arr));
//    }
//}

//4.求数组中元素的平均值
//public class Test{
//    public static double avg(int[] arr){
//        int sum = 0;
//        for(int i = 0;i < arr.length;i++){
//            sum += arr[i];
//        }
//        return (double)(sum) / (double)(arr.length);
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(avg(arr));
//    }
//}

//5.查找数组中的指定元素(顺序查找)
//public class Test{
//    public static int find(int[] arr,int toFind) {
//        for (int i = 0; i < arr.length; i++) {
//            if (toFind == arr[i]) {
//                return i;
//            }
//        }
//        return -1;
//    }
//        public static void main (String[]args){
//            int[] arr = {1, 2, 3, 4, 5, 6};
//            int toFind = 3;
//            System.out.println(find(arr, toFind));
//        }
//}

//6.查找数组中的指定元素(二分查找)
//public class Test{
//    public static int binarySearch(int[] arr,int toFind){
//        int left = 0;
//        int right = arr.length - 1;
//        while(left <= right){
//            int mid = (left + right)/2;
//            if(toFind < arr[mid]){
//                right = mid - 1;
//            }else if(toFind > arr[mid]){
//                left = mid + 1;
//            }else{
//                return mid;
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        int toFind = 3;
//        System.out.println(binarySearch(arr,toFind));
//    }
//}

//7.检查数组的有序性(升序)
//public class Test{
//    public static boolean isSorted(int[] arr){
//        for(int i = 0;i < arr.length - 1;i++){
//            if(arr[i] > arr[i + 1]){
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        int[] arr= {1,2,3,4,5,6};
//        System.out.println(isSorted(arr));
//    }
//}

//8.数组排序(冒泡排序)
//import java.util.Arrays;
//public class Test{
//    public static void bubbleSort(int[] arr){
//        for(int bound = 0;bound < arr.length;bound++){
//            for(int cur = arr.length - 1;cur > bound;cur--){
//                if(arr[cur - 1]>arr[cur]){
//                    int tmp = arr[cur - 1];
//                    arr[cur-1] = arr[cur];
//                    arr[cur] = tmp;
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//}

//9.数组逆序
//import java.util.Arrays;
//public class Test{
//    public static void reserve(int[] arr){
//        int left = 0;
//        int right = arr.length - 1;
//        while(left < right){
//            int tmp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = tmp;
//            left++;
//            right--;
//        }
//}
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        reserve(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//}

//10.数组数字排列
//import java.util.Arrays;
//public class Test{
//    public static void transform(int[] arr){
//        int left = 0;
//        int right = arr.length - 1;
//        while(left < right){
//            while(left < right && arr[left] % 2 == 0){
//                left++;
//            }】
//            while(left < right && arr[right] %2 != 0){
//                right--;
//            }
//           int tmp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = tmp;
//        }
//    }
//    public static void main(String[] args) {
//        int []arr = {1,2,3,4,5,6};
//        transform(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//}

//1.给定两个整型数组, 交换两个数组的内容.
//import java.util.Arrays;
//public class Test{
//    public static void main(String[] args) {
//        int[] arr1 = {1,2,3,4};
//        int[] arr2 = {5,6,7,8};
//        for(int i = 0;i < arr1.length;i++){
//            int tmp = arr1[i];
//            arr1[i] = arr2[i];
//            arr2[i] = tmp;
//        }
//        System.out.println("arr1 ="+Arrays.toString(arr1));
//        System.out.println("arr2 ="+Arrays.toString(arr2));
//    }
//}

//2.给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
//import java.util.Arrays;
//public class Test{
//    public static void transform(int[] arr){
//        int left = 0;
//        int right = arr.length - 1;
//        while(left < right){
//            while(left < right && arr[left] % 2 ==0){
//                left++;
//            }
//            while(left < right && arr[right] % 2 !=0){
//                right--;
//            }
//            int tmp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = tmp;
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        transform(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        int x = 20;
//        int y = 5;
//        System.out.println(x + y + "" + (x + y) +y);
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        int i = 1;
//        int j = 2;
//        System.out.println(i+j);
//    }
//        }

//1.数组转字符串
//public class Test{
//    public static String toString(int[] arr){
//        String ret = "[";
//        for(int i = 0;i < arr.length;i++){
//            ret += arr[i];
//            if(i != arr.length -1) {
//                ret += ",";
//            }
//        }
//        ret += "]";
//        return ret;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(toString(arr));
//    }
//}

//2.数组拷贝
//import java.util.Arrays;
//public class Test{
//    public static int [] copyOf(int[] arr)
//    {
//        int[] ret = new int [arr.length];
//        for(int i = 0;i < arr.length;i++){
//            ret[i] = arr[i];
//        }
//        return ret;
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(Arrays.toString(copyOf(arr)));
//    }
//}


//import java.util.Arrays;

//3.找到数组中的最大元素
//public class Test{
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(max(arr));
//    }
//    public static int max(int[] arr){
//        int max = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] > max){
//                max = arr[i];
//            }
//        }
//        return max;
//    }
//}

//4.求数组中元素的平均值
//public class Test{
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(avg(arr));
//    }
//    public static double avg(int[] arr){
//        int sum = 0;
//        for(int i = 0;i <arr.length;i++){
//            sum += arr[i];
//        }
//        return (double)sum / (double)arr.length;
//    }
//}

//5.查找数组中的指定元素
//public class Test{
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(find(arr,4));
//    }
//    public static int find(int[] arr,int toFind){
//        for(int i =0;i < arr.length;i++){
//            if(arr[i] == toFind){
//                return i;
//            }
//        }
//        return -1;
//    }
//}




















































































































