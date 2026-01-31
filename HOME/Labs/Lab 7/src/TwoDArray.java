public class TwoDArray {
    public static void main(String[] args) {
        // int [][] avgTemps = new int[][];
        // avgTemps[0][0] = 65;
        // avgTemps[0][1] = 70;
        // avgTemps[0][2] = 72;

        // avgTemps[1][0] = 60;
        // avgTemps[1][1] = 70;
        // avgTemps[1][2] = 69;

        // avgTemps[2][0] = 70;
        // avgTemps[2][1] = 70;
        // avgTemps[2][2] = 71;

        // avgTemps[0][0] = 90;
        // avgTemps[0][1] = 67;
        // avgTemps[0][2] = 60;
        
        int [][] avgTemps ={
            {65, 70, 72},
            {60, 70, 69},
            {60, 70, 71},
            {90, 67, 60}
            };
        int [] sum = new int[3];
        for(int j=0; j<avgTemps[0].length; j++)
        {   
            sum[j]=0; 
            for(int i=0; i< avgTemps.length; i++)
            {
                System.out.println(avgTemps[i][j]);
                sum[j]= sum[j]+avgTemps[i][j];
            }
            System.out.println("Total temperature:"+sum[j]);
            System.out.printf("Mean temperature %d",sum[j]/avgTemps.length);

        }
    }
}
