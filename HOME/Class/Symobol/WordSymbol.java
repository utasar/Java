import java.util.Scanner;

public class WordSymbol {
    public static void main(String[] args) 
    {
        // System.out.print("Enter a number(Integer) word and symbol: 23 hi $$");   
        // Scanner In = new Scanner(System.in) ;  
        //     System.out.println("Number: "+In.next());
        //     System.out.println("Word: "+In.next());
        //     System.out.println("Symbol: "+In.next());
        // In.close();
        System.out.print("Enter the monthly pay:");
        Scanner In=new Scanner(System.in);
        Double SalaryTax= In.nextDouble()*20.00/100.00;
        System.out.println(SalaryTax);

    }
}
