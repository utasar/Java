import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        int[] valsArray = new int[3];
        String[] stringArray =  new String[]{"cat","Mat","Bat"};
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(stringArray));
        System.out.println(wordsList);
        Collections.shuffle(wordsList);

        // create an arraylist: for example arraylist of integer
        ArrayList<Integer> vals = new ArrayList<Integer>();
        ArrayList<String> valString = new ArrayList<String>();
        vals.add(20);
        vals.add(35);
        vals.add(5);
        for(int number: vals){
            System.out.println(number);
        }
        for(int i=0; i<vals.size();i++)
        {
            System.out.println(vals.get(i));
        }
        valString.add("Dog");
        valString.add("Buffalo");
        valString.add("Makuri");
        Collections.shuffle(valString);
        System.out.println(valString);
        Collections.shuffle(valString);
        // Find unique letter in array:
        
    }

}
