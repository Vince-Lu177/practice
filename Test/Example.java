
//public class Example {
//        String str = new String("good");
//        char[ ] ch = { 'a' , 'b' , 'c' };
//        public static void main(String args[]){
//            Example ex = new Example();
//            ex.change(ex.str,ex.ch);
//            System.out.print(ex.str + " and ");
//            System.out.print(ex.ch);
//        }
//        public void change(String str,char ch[ ]){
//            str = "test ok";
//            ch[0] = 'g';
//        }
//}
//public class Example{
//    public static boolean isAdmin(String userId){
//        return userId.toLowerCase().equals("admin");
//    }
//    public static void main(String[] args){
//        System.out.println(isAdmin("Admin"));
//    }
//}
//java实现IndexOf方法
//方法一
public class Example {
    public static int indexOf(String src, String dst) throws Exception {
        if (null == src || src.length() < 1 || null == dst || dst.length() < 1) {
            return -1;
        }
        if (dst.length() > src.length()) {
            return -1;
        }
        char[] srcArray = src.toCharArray();
        char[] dstArray = dst.toCharArray();
        int srclen = srcArray.length;
        int dstlen = dstArray.length;
        for (int i = 0; i < srclen; i++) {
            boolean find = false;
            if (srcArray[i] == dstArray[0] && (i + dstlen <= srclen)) {
                int equalCount = 0;
                for (int j = 0; j < dstlen; j++) {
                    if (srcArray[i + j] == dstArray[j]) {
                        equalCount++;
                    }
                }
                if (equalCount == dstlen) {
                    find = true;
                }
            }
            if(find){
                return  i;
            }
        }
        return -1;
    }
}



