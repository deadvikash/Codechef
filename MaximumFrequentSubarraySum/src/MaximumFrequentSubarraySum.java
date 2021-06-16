import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumFrequentSubarraySum {

    static int maxSubArraySum(long a[], int size)
    {
        long max_so_far = a[0];
        long curr_max = a[0];

        for (int i = 1; i < size; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return (int) max_so_far;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < t; i++) {
            String line1 = bufferedReader.readLine();
            String[] in1 = line1.trim().split("\\s+");
            long n = Long.parseLong(in1[0]);
            long[] a = new long[(int) n];
            String line = bufferedReader.readLine();
            String[] in = line.trim().split("\\s+");
            for (int j = 0; j < n; j++){
                a[j] = Long.parseLong(in[j]);
            }
            int maxScore1 = MaximumFrequentSubarraySum.maxSubArraySum(a, (int) n);

            int count = 0;
            long maxScore2 = 0;
            List<Integer> list = new ArrayList<>();
            boolean check = false;
            for(int j = 0; j < n-1; j++){
                    if(a[j] == a[j+1]){
                        count++;
                        list.add((int) a[j]);
                        check = true;
                    }
                    if(check == true){
                        if(a[j] != a[j+1] || j == n -2){
                            list.add((int) a[j] * 2 * count);
                            count = 0;
                        }
                    }

            }
            Collections.sort(list);
            if(list.size() != 0)
            maxScore2 = list.get(list.size() - 1);
            if(maxScore2 > maxScore1)
                System.out.println(maxScore2);
            else
                System.out.println(maxScore1);
        }
    }
}
