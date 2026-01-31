public class BreakAndContinue {
   public static void main(String [] args){
      int result;
      int n;

      result = 0;
      
      for (n = 0; n < 6; ++n) {
         result = n + 3;
         
         if ((result % 2) != 0) {
            System.out.print("_");
            continue;
         }
         
         System.out.print(result);
      }
      
      System.out.println();
   }
}
