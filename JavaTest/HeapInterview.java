package practice.practice.JavaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapInterview {
     class pair implements Comparable<pair>{
        public int n1;
        public int n2;
        public int sum;
        public pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            sum = n1 + n2;
        }

        @Override
        public int compareTo(pair o) {
            //this > other,返回大于0的树
            //this < other,返回小于0的树
            //this = other,返回等于0的树
            return this.sum - o.sum;
        }
    }

    //[
    //   [1,1]
    //]
    //返回值的二维数组中，每一行是一个数对(每行只有两个元素)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k <= 0){
            return result;
        }
        //当前只需要前k小的元素，建立一个小堆
        PriorityQueue<pair> queue = new PriorityQueue<>();
        //所有的可能数对都获取到队列中
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new pair(nums1[i],nums2[j]));
            }
        }
        //循环结束，所有的数对都在队列中，循环取出前k个元素即可
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            pair cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.n1);
            tmp.add(cur.n2);
            result.add(tmp);
        }
        return result;
    }
}
