package Practice_0628;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String classCount = scanner.nextLine();
        String studyPoint = scanner.nextLine();
        String score = scanner.nextLine();
        String[] studyPointArr = studyPoint.split(" ");
        String[] scoreArr = score.split(" ");
        double sum = 0.0;
        int studyPoint_sum = 0;
        for (int i = 0; i < scoreArr.length; i++) {
            studyPoint_sum += Integer.parseInt(studyPointArr[i]);
            sum += getScorePoint(Integer.parseInt(scoreArr[i])) * Integer.parseInt(studyPointArr[i]);
        }
        System.out.printf("%.2f",sum/studyPoint_sum);
    }
    private static double getScorePoint(int score){
        if(score>=90&&score<=100){
            return 4.0;
        }else if(score>=85&&score<=89){
            return 3.7;
        }else if(score>=82&&score<=84){
            return 3.3;
        }else if(score>=78&&score<=81){
            return 3.0;
        }else if(score>=75&&score<=77){
            return 2.7;
        }else if(score>=72&&score<=74){
            return 2.3;
        }else if(score>=68&&score<=71){
            return 2.0;
        }else if(score>=64&&score<=67){
            return 1.5;
        }else if(score>=60&&score<=63){
            return 1.0;
        }else
            return 0.0;
    }
}
