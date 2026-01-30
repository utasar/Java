import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//make all necessary imports: you cannot use "import java.util.*"
//NOTE: This code has been sabotaged

public class PlayListManager {
    public static void main(String[] args) throws IOException{
      
        ArrayList<String> cartList = readDataFromFile("PlayList.txt");
        checkAndPrintSameItems(cartList);
    }

    public static ArrayList<String> readDataFromFile(String fileName) throws IOException{
        FileInputStream inputStream = new FileInputStream("Playlist.txt");
        Scanner inpScnr = new Scanner(inputStream);
        ArrayList<String> songsList = new ArrayList<String>();

        while(inpScnr.hasNextLine()){
            songsList.add(inpScnr.nextLine());
        }

        inputStream.close();
        inpScnr.close();

        return songsList;      
    }

    public static void checkAndPrintSameItems(ArrayList<String> songsList){

        for(int i = 0; i < songsList.size(); ++i){
            for(int j = i+1; j < songsList.size(); ++j){
                if(songsList.get(i).equals(songsList.get(j))){
                    System.out.println("This song is already on your playlist: " + songsList.get(i));
                }
            }
        }
       // System.out.println("End of coding");
    }

}
