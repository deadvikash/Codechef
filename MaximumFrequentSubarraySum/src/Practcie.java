import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practcie {

    public void printSubArrays(int [] arrA){

        int arrSize = arrA.length;
        List<Integer> list = new ArrayList<>();
        //start point
        for (int startPoint = 0; startPoint <arrSize ; startPoint++) {
            for (int grps = startPoint; grps <= arrSize; grps++) {
                int sum = 0;
                for (int j = startPoint; j < grps; j++) {
                    System.out.print(arrA[j] + " ");
                    sum += arrA[j];
                }
                System.out.println();
                if(sum!= 0)
                list.add(sum);

            }
        }
        Collections.sort(list);
        System.out.println(list);
    }


    public static void main(String[] args) {
        int [] arrA = {10, 8, -20, 5, 5, 5};
        new Practcie().printSubArrays(arrA);
    }
}
