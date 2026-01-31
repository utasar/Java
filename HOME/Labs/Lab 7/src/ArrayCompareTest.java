import java.util.Arrays;

public class ArrayCompareTest {
    public static void main(String[] args) {
        int [] arr1={1,2,3,4};
        int [] arr2 ={1,2,3,4};
        if (arr1==arr2)
            System.out.println("true");
        else
            System.out.println("false");

        if (Arrays.equals(arr1, arr2)){
        System.out.println("True");
        System.out.println("Iteration 1");
        for(int i=10; i>0;i--)
            System.out.println("Hello world!!");
        System.out.println("Iteration 2");
        int i=0;
            while (i<10) {
                System.out.println("Hello WOrld");
                i++;
            }
        }
        else
        System.out.println("false");
    }
}
