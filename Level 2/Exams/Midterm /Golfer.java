// Acharya
package Midterm;

public class Golfer extends Athlete {
    private String league;

    public Golfer(String name, String league) {
        super(name, "golf");
        this.league = league;
    }

    public String toString() {
        return super.toString() + " in the " + league;
    }

    public int getWorstScore() {
        sortScores();
        return scores.get(scores.size() - 1);        
    }
}
