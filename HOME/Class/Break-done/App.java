public class App {
    public static void main(String[] args) throws Exception {
        // for(int i=0; i<6;++i){
        //     if (i==3)
        //         continue; // continue skips that steps
        //     System.out.println(i);
        // }
        int i=0;
        while (i<6)
        {
            i++;

            if(i%2==0)
            {
                continue;
            }

            System.out.println(i);
        }
    }
}
