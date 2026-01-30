public class CompoundOperators {
    public static void main(String[] args) throws Exception {
        //Integer>>>
        //integer wraparound
        int number =2147483647;
        int maxNumber= Integer.MAX_VALUE+1; // result lowest maximum value by wraparound
        System.out.println(maxNumber);
        int minNumber= Integer.MIN_VALUE-1; // result to maximum highest value by wraparound
        System.out.println(minNumber);        
    }
}
