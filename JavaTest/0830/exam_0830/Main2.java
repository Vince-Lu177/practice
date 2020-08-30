package exam_0830;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.nextLine();
        int num = Integer.parseInt(n);
        String[] lines = new String[num];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = scanner.nextLine();
        }
        int[] id = new int[num];
        int[] grade = new int[num];
        for (int i = 0; i < num; i++) {
            String[] strings = lines[i].split(" ");
            id[i] = Integer.parseInt(strings[0]);
            grade[i] = Integer.parseInt(strings[1]);
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (grade[j] > grade[j + 1]) {
                    int tmp = grade[j + 1];
                    grade[j + 1] = grade[j];
                    grade[j] = tmp;
                    tmp = id[j + 1];
                    id[j + 1] = id[j];
                    id[j] = tmp;
                } else if (grade[j] == grade[j + 1]) {
                    if (id[j] > id[j + 1]) {
                        int tmp = id[j];
                        id[j] = id[j + 1];
                        id[j + 1] = tmp;
                    }
                }
            }
        }
        for (int i = 0; i < num; i++) {
            System.out.println(id[i] + " " + grade[i]);
        }
    }
}


