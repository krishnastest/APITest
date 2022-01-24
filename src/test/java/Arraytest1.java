import java.util.ArrayList;
import java.util.Arrays;

public class Arraytest1 {

    public static void main(String[] args){

    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 2, 3));
// first for loop should be for the new output array
// input should be taken from user
// both  array size should be same  from beginning
    int count =0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i == numbers.get(j)) {
                    count += 1;
                }
            }
            integers.add(count);
            count = 0;
        }
        System.out.println(Arrays.toString(new ArrayList[]{integers}));
    }
}
