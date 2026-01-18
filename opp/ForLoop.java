public class ForLoop {
    public static void main(String[] args) {
        //1. initialize
        //2.condition
        //3.update/modify
    for (int i = 1; i<5; i++){
        //loop statement 
        System.out.println("Loop" + i);
    }
    //Decrement
    int dec;
    for(dec = 5; dec>=1; dec -=2){
        System.out.println("Loop dec by two"+dec);
        }
    //Nested loop
    for (int row = 1; row <=5; row++){
        System.out.println("Outer loop" +row);
        for(int col = 5; col > 1; col --){
            System.out.println("Inner loop" +col);
        }
        System.out.println("Inner loop exit ");
    }
    System.out.println("Outer loop exit");
    }
}
