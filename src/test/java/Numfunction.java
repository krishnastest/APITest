import java.util.Arrays;
import java.util.Scanner;

public class Numfunction {
    public static void main(String[] args) {

        int n, counter = 0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        n=sc.nextInt();
        int[] num = new int[n];
        int[] output = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++){
            num[i]=sc.nextInt();
        }
        System.out.println("Array elements are:" + Arrays.toString(num));
        for (int j = 0; j < num.length; j++){
            for( int i=0; i<num.length;i++){
                if (j==num[i]){
                    counter= counter+1;
                    System.out.println(counter);
            }
                output[j]=counter;
                counter=0;
            }
        }
        System.out.println("New array elements are:" + Arrays.toString(output));


    }
}
