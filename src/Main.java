import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {

            ArrayList<Integer> dist = new ArrayList<>();
            int realDist = 0;
            for (int j = 0; j < n; j++) {
                if (i==j) {
                    continue;
                }
                dist.add(Math.abs(a[i] - a[j]));
            }
            for (int j = 0; j < k; j++) {
                int min = Collections.min(dist);
                realDist += min;
                dist.remove((Integer) min);
            }
            System.out.print(realDist + " ");
        }
    }
}