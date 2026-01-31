public class ShortingArrayElements {
    public static void main(String[] args) {
        int[] numberArray = {1,2,3};
  
       
        // exchange the array elements goes here

        for (int i=1;i<numberArray.length/2;i++){
           
                int temp = numberArray[i-1];
                numberArray[i-1]=numberArray[numberArray.length-i];
                numberArray[numberArray.length-i]=temp; 

        }
                System.out.println(numberArray[0]);
        System.out.println(numberArray[1]);
        System.out.println(numberArray[2]);
    }
    
}
