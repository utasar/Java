
import java.util.Scanner;
public class TriviaChallenge {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        int rightAns = 0; //initialization of right answers to 0
        int rightPct; // since there are total 5 questions only so no need to use floating point
        System.out.println("How many states are in the United States?");
        int stateUSA = scnr.nextInt(); //take Input for number of states
        if (stateUSA==50)
            {
                rightAns++; // increment right answers
                System.out.println("Correct!");
                System.out.println("___________");
            }
        else
            {
                System.out.println("Incorrect!");
                System.out.println("___________");
            }
        System.out.println("Who was the first president of the United States (Full Name)?");
        String presidentUSA = scnr.next();// take first name of the president
        presidentUSA = presidentUSA +" "+ scnr.next(); // take second name and concate with first name
        if (presidentUSA.toUpperCase().equals("GEORGE WASHINGTON")) // toUpperCase and toLowerCase can be used 'george washington'
            {
                rightAns++;
                System.out.println("Correct!");
                System.out.println("-------------");
            } 
        else
            {
                
                System.out.println("Incorrect!");
                System.out.println("-------------");
            }
        System.out.println("The sun is a star (True/False only)");
        boolean isStar = scnr.nextBoolean();// in boolean True, true and TRUE is same & false False FALSE is same
        if (isStar)
            {
                rightAns++;
                System.out.println("Correct!");
                System.out.println("-------------");
            }
        else
            {
                System.out.println("Incorrect!");
                System.out.println("-------------");
            }
        System.out.println("What is the value of Pi up to the second decimal point? (Only enter 2 decimal place)");
        double valPI = scnr.nextDouble(); 
        if (Math.abs(Math.PI-valPI)<0.001593) //floating point comparison 
            {
                rightAns++;
                System.out.println("Correct!");
                System.out.println("-------------");
            } 
        else
            {
                System.out.println("Incorrect!");
                System.out.println("-------------");
            }
        System.out.println("What is the first letter of the English alphabet");
        char firstAlpha = scnr.next().charAt(0);
        if (firstAlpha=='A'||firstAlpha=='a') // both upper case and lower case treated as first letter
            {
                rightAns++;
                System.out.println("Correct!");
                System.out.println("-------------");
            }
        else
            {
                System.out.println("Incorrect!");
                System.out.println("-------------");
            }
        rightPct = rightAns*100/5;
        System.out.println("===========================================================");
        System.out.printf("You got %d out of 5 right for a score of %d%% \n",rightAns,rightPct); // 5 is fix numbers of questions 
        System.out.println("===========================================================");
        // in above output 5 is hard quoted since question says series of 5 questions
        scnr.close();
    }
}
