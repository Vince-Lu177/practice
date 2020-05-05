package Practice0505;

public class Test {
    //1.字符转小写
    public String toLowerCase(String str) {
        String res = str.toLowerCase();
        return res;
    }

    //2.判断是否为回文数
    //方法1:把整数转成字符串,对字符串进行逆置,与原字符串进行比较,看是否相等
    public boolean isPalindrome(int x){
        String s = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(s);
    }
    //方法2:取出x的第m和倒数第m位进行比较
    public boolean isPalindrome2(int x){
        int n = 1;//保存x的最高位数
        while (x / n >= 10){
            n *= 10;
        }
        while(x > 0){
            int left = x / n;
            int right = x % 10;
            if(left != right){
                return false;
            }
            x = (x % n) / 10;
            n /= 100;
        }
        return true;
    }
    //方法3:
    public boolean isPalindrome3(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int m = 0;
        while(x > m){
            m = m * 10 + x % 10;
            x /= 10;
        }
        return m == x || x == m / 10;
    }


    public static void main(String[] args) {
        Test test = new Test();
        //System.out.println(test.isPalindrome(1221));
        //System.out.println(test.isPalindrome2(1221));
        System.out.println(test.isPalindrome3(1232));
    }
}
