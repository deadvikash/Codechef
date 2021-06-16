import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NonDivisibleSubset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }
        int[] remainder = new int[k];
        for (int i = 0; i < n; i++) {
            remainder[s.get(i) % k]++;
        }
        int zeroRemainder = remainder[0];
        int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;
        for (int i = 1; i <= (k / 2); i++) {
            if (i != k - i)
                maxNumberOfDivisibleSet += Math.max(remainder[i], remainder[k - i]);
            else
                maxNumberOfDivisibleSet++;

        }

        System.out.println(maxNumberOfDivisibleSet);
    }
}
