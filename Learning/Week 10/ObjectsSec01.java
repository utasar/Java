public class ObjectsSec01
{
    public static void main(String[] args)
    {
        PixelSec01 name = new PixelSec01();
        System.out.println(name.getX());
        System.out.println(name.getY());

        PixelSec01 name2 = new PixelSec01(5, 5);
        System.out.println(name2.getX());
        System.out.println(name2.getY());

        name2.setX(-10);
        System.out.println(name2.getX());
    }
}
