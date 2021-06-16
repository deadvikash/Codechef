import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathBuzz {

    public static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(bufferedReader.readLine().trim());
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        String line1 = bufferedReader.readLine();
        String[] in = line1.trim().split("\\s+");
        long[] a = new long[k];
        long[] p = new long[k];
        String line = bufferedReader.readLine();
        String[] in1 = line.trim().split("\\s+");
        long sol = 0;

        int j = 0;
        long[] c = new long[k];
        for(int i = 0; i < k; i++){
            a[i] = Long.parseLong(in[i]);
            p[i] = Long.parseLong(in1[j]);
            j++;

                int n = MathBuzz.factorial((int) a[i]);
                int r1 = MathBuzz.factorial(r);
                c[i] = n/((r1)*(n-r1));
        }
        for(int i = 0; i < k; i++){
            sol += c[i]%998244353;
        }

        System.out.println(sol);
    }
}
