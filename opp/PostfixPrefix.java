public class PostfixPrefix {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 22;
        //Prefix, ahead of varriable or value ++number
        System.out.println("Prefix");
        System.out.println(++num1); //the value of num1 changes in this line 
        System.out.println(num1);
    
            //Postficx, behind of variable or value number ++
        System.out.println("Postfix");
        System.out.println(num2++);
        System.out.println(num2);
        }
    }
