// Utsav
package Midterm;

public class Driver {

    public static void main(String[] args) {
        Athlete a = new Athlete("Amy Adkins", "basketball");
        a.addScore(12);
        a.addScore(16);
        a.addScore(4);
        a.addScore(13);
        System.out.println(a);
        System.out.println("Worst score: " + a.getWorstScore());

        Golfer g = new Golfer("Barry Badinski", "LIV");
        g.addScore(81);
        g.addScore(68);
        g.addScore(72);
        System.out.println(g);
        System.out.println("Worst score: " + g.getWorstScore());
    }
}
