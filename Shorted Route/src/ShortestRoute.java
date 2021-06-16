import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortestRoute {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < t; i++) {
            String line1 = bufferedReader.readLine();
            String[] in1 = line1.trim().split("\\s+");
            long N = Long.parseLong(in1[0]);
            long M = Long.parseLong(in1[1]);
            long[] A = new long[(int) N];
            long[] B = new long[(int) M];
            String line = bufferedReader.readLine();
            String[] in = line.trim().split("\\s+");
            List<Long> count = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                A[j] = Long.parseLong(in[j]);
            }
            long[] countLeft = new long[(int) N];
            long[] countRight = new long[(int) N];
            boolean ifOne = false;
            boolean ifTwo = false;
            int g = 0;
            int h = 0;
            for(int k = 0, l = (int) (N-1); k < N && l >= 0; k++, l--){

                if(A[k] == 1){
                    countLeft[k] = 0;
                    g = k;
                    ifOne = true;
                }
                else if(A[k] == 0 || A[k] == 2){
                    if(!ifOne)
                        countLeft[k] = -1;
                    else
                        countLeft[k] = k - g;
                }
                if(A[l] == 2){
                    countRight[l] = 0;
                    h = l;
                    ifTwo = true;
                }

                else if(A[l] == 0 || A[l] == 1){
                    if(!ifTwo)
                        countRight[l] = -1;
                    else
                        countRight[l] = h - l;
                }
            }
            int[] Result = new int[(int) M];
            String line2 = bufferedReader.readLine();
            String[] strs2 = line2.trim().split("\\s+");
            for(int j = 0; j < M; j++){
                B[j] = Long.parseLong(strs2[j]);
                if(B[j] == 1)
                    Result[j] = 0;
                else if(countLeft[(int) (B[j]-1)] >= 0 && countRight[(int) (B[j]-1)] >= 0){
                    Result[j] = (int) Math.min(countLeft[(int) (B[j] - 1)], countRight[(int) (B[j] - 1)]);
                }
                else if(countLeft[(int) (B[j]-1)] >= 0 && countRight[(int) (B[j]-1)] < 0){
                    Result[j] = (int) countLeft[(int) (B[j]-1)];
                }
                else if(countLeft[(int) (B[j]-1)] < 0 && countRight[(int) (B[j]-1)] >= 0){
                    Result[j] = (int) countRight[(int) (B[j]-1)];
                }
                else
                    Result[j] = -1;
            }
            System.out.println(Arrays.toString(Result).replace("[","").replace("]","").replace(",",""));
        }
    }
}
