import java.util.ArrayList;
import java.util.Arrays;
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

        Integer[] arrSorted = a.clone();
        Arrays.sort(arrSorted);

        scanner.close();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> aSort = new ArrayList<>(Arrays.asList(arrSorted));
            int kCount = k;
            Integer aI = a[i];
            int dist = 0;
            int indexOnSorted = aSort.indexOf(aI);
            while (kCount > 0) {
                int left;
                int right;
                try {
                    left = aSort.get(indexOnSorted - 1);
                } catch (Exception e) {
                    right = aSort.get(indexOnSorted + 1);
                    dist += Math.abs(aI - right);
                    aSort.remove(indexOnSorted + 1);
                    kCount -= 1;
                    continue;
                }
                try {
                    right = aSort.get(indexOnSorted + 1);
                } catch (Exception e) {
                    left = aSort.get(indexOnSorted - 1);
                    dist += Math.abs(aI - left);
                    aSort.remove(indexOnSorted - 1);
                    indexOnSorted -= 1;
                    kCount -= 1;
                    continue;
                }
                if (Math.abs(aI - left) > Math.abs(aI - right)) {
                    dist += Math.abs(aI - right);
                    aSort.remove(indexOnSorted + 1);
                } else if (Math.abs(aI - left) < Math.abs(aI - right)) {
                    dist += Math.abs(aI - left);
                    aSort.remove(indexOnSorted - 1);
                    indexOnSorted -= 1;
                } else if (Math.abs(aI - left) == Math.abs(aI - right)) {
                    dist += Math.abs(aI - right);
                    aSort.remove(indexOnSorted + 1);
                }

                kCount -= 1;
            }
            System.out.print(dist + " ");
        }

        /*
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

         */
    }
}
