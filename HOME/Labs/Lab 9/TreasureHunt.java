public class TreasureHunt {
  
public static void main(String[] args) 
    {
        // Predefined treasure map
        char[][] treasureMap = {
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '+', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-','-', '-', '-', '-', '-', '-'},
        };
        
        getCoordinates(treasureMap);
    }
/**
 * output the row and column number in which '+' sign given a 2D character array.
 * @param map A 2D character array representing the treasure map with '+' and '-' signs.
 */
public static void getCoordinates(char[][] treasureMap) {
    for (int i = 0; i < treasureMap.length; i++) {
        for (int j = 0; j < treasureMap[i].length; j++) {
            if (treasureMap[i][j] == '+') {
               
                //System.out.println("Row: " + i+1 + ", Column: " + j+1);
                System.out.printf("Row: %d, Column: %d\n",i+1,j+1);
            }
        }
    }
} 
}
