public class Bag 
{
    private int noOfPockets;
    private double volume;
    private boolean isFull;
    private boolean isEmpty;
    private double volumeOfStuffs;
    private boolean hasZipper;

    //create get and set for get
    public void setvolume(double volume)
        {
           this.volume=volume; 
        }
    public double getVolume()
        {
            return volume;
        }
    // constructor
    public Bag(boolean hasZipper,boolean isEmpty)
        {
         this.hasZipper = hasZipper;  
         this.isEmpty =isEmpty; 
        }
    // constructor overloading
    public Bag(double volume)
        {
            this.volume =volume;
        }
    public static boolean fillUpstuffs(double stuffsVolume) 
        {
            
            return false;
        }
    public static boolean takeOffstuffs(double stuffsVolume)
        {
            
            return false;
        }
    private static double hasSpace()
        {
            return 0.0;
        }
}
