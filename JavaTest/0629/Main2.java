package Practice_0629;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //候选人数
        String candidateNum = scanner.nextLine();
        //候选人
        String candidate = scanner.nextLine();
        String[] arr = candidate.split(" ");
        //投票数
        String voteNum = scanner.nextLine();
        //给候选人投票
        String vote = scanner.nextLine();
        String[] arr2 = vote.split(" ");
        Map<String,Integer> candidateMap = new HashMap<>();
        for(String s : arr){
            Integer value = candidateMap.get(s);
            if(value == null){
                candidateMap.put(s,0);
            }
        }
        for(String s : arr2){
            Integer value = candidateMap.get(s);
            if(value != null){
                candidateMap.put(s,value+1);
            }
        }
        int count = 0;
        for(Map.Entry<String,Integer> entry : candidateMap.entrySet()){
            count+=entry.getValue();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Invalid : " + count);
        
    }
}
