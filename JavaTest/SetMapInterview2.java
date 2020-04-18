package practice.practice.JavaTest;

import java.util.*;

public class SetMapInterview2 {
    //坏键盘打字
    //旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
    //现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
    //键盘上某个键坏了，对应的大小写都无法输出，需要把大小写视为一种情况
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //1.先循环读入两个字符串，第一个为预期输出的内容，第二个为实际输出的内容
            String expected = scanner.next();
            String actual = scanner.next();
            //2.把读入的两个字符串都转换成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            //3.题目中的主要任务是判定预期输出的字符在实际输出的字符串是否存在
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                //set中不能有重复元素，add过程中发现元素已经存在，就会插入失败
                actualSet.add(actual.charAt(i));
            }
            //4.创建一个set，把预期输出的每个字符都存进去，就可以遍历预期输出字符串，就可以遍历实际输出字符串，判断是否在set中存在
            Set<Character> brokenKeySet = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if(actualSet.contains(c)){
                    //当前字符已经被输出了，说明是一个好键
                    continue;
                }
                //5.经过上述检查，现在剩下的就是坏了的键
                //预期字符串可能存在出现多次坏键，但最终结果只需要，所以需要去重(使用set)
                if(brokenKeySet.contains(c)){
                    continue;
                }
                System.out.print(c);
                brokenKeySet.add(c);
            }
        }
    }

    //前K个高频单词
    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    public List<String> topKFrequent(String[] words, int k) {
        //1.先统计这个数组中每个单词出现的次数(Map)
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            Integer count = map.getOrDefault(s,0);
            map.put(s,count + 1);
        }//2.把键值对组织到一个ArrayList中
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        //keySet相当于得到一个set，存放所有的key
        //3.按照字符串出现的次数，针对ArrayList进行排序
        Collections.sort(arrayList,new myComparator(map));
        //sort默认是按照自身大小进行升序排序(String的字典序)
        //此处需要按照字符串出现次数进行降序排序，需要用过比较器自定制比较
        return arrayList.subList(0,k);
    }

    static class myComparator implements Comparator<String>{
        private Map<String,Integer> map;

        public myComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String s, String t1) {
            int count1 = map.get(s);
            int count2 = map.get(t1);
            if(count1 == count2){
                return s.compareTo(t1);
                //String自身实现了comparable接口，自带字典序比较功能
                //compareTO就是再使用默认的比较规则
            }
            return count2 - count1;
        }
    }
}




