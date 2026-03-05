import java.util.*;

public class ECB_CandyCounting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine(); // Clear newline character

        // Accept only n <= 100 else exit program
        if (n > 100) {
            System.exit(0);
        }
        String[] candy = new String[n];

        for (int i = 0; i <= candy.length - 1; i++) {
            candy[i] = input.nextLine();
        }
        input.close();

        System.out.println();
        System.out.println(MostFrequentCandy(candy)); 
    }

    public static String MostFrequentCandy(String[] candy) {
        int[] candyCount = new int[candy.length];
        String mostFrequentCandy = "";
        int mostFrequentCandyCount = 0;
        
        for (int i = 0; i <= candy.length - 1; i++) {
            candyCount[i] = 0;
            for (int j = 0; j <= candy.length - 1; j++) {
                if (candy[i].equals(candy[j])) {
                    candyCount[i]++;
                }
            }
            if (candyCount[i] > mostFrequentCandyCount) {
                mostFrequentCandyCount = candyCount[i];
                mostFrequentCandy = candy[i];
            }
        }
        return mostFrequentCandy;
    }
}

/*
The neighbor kid from across the street is taking stock of her trick-or-treating
haul. She has drafted you as her accountant. She pulls each piece of candy out
of her bucket one at a time and tells you what it is. Your job is to let her know
which type of candy she has the most of.

Input: The input will begin with a positive integer representing the number of
pieces of candy, n <= 100. The next n lines will contain the name of each type of
candy, one per line.

Output: The output should be the name of the type of candy that appears
most frequently in the list. There will always be a single type of candy that
appears most frequently (i.e. there will never be any “ties”).

Sample Input

10
Kit-kat
Snickers
Sweet Tarts
Reeses Peanut Butter Cup
Snickers
Kit-kat
Snickers
Kit-kat
Snickers
Snickers

Sample Output

Snickers
 */
