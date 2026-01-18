public class UserInputUsingArgs {
    public static void main(String[] args) {
        //The paramenter string[]args takes array of input 
        //when running from command line 
        //you can compile java file with 
        //javac FileName.java
        //java FileName agrs 1 args 2
        //or 
        //java FileName.java args1 args2
        System.out.println("First Args" + args[0]);
        System.out.println("second Args"+args[1]);

        //The args are in datatype string to convert or parse any args 
        int argsParse1 = Integer.parseInt(args[0]);
        int argsParse2 = Integer.parseInt(args[1]);
        System.out.println("sum of args" + (argsParse1+argsParse2));

        // Task
        // create a new file ResultInput
        //create Scanner object to ask user for input 
        // opp-> int 
        // database-> int
        // architecture-> int
        // resit-> boolean 
        // calculate the avg 
        // if resit is true cap the avg to 40 is the value is more than 40 
        // using printf print each marking 
        // also print if the avg is greater or equal to 40-> "Good" else "Bad"
    }
}
