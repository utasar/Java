// Utsav Acharya
package Midterm;

import java.util.ArrayList;
import java.util.Collections;

class Athlete {
    private String name;
    private String sport;
    protected ArrayList<Integer> scores;

    public Athlete(String name, String sport) {
        this.name = name;
        this.sport = sport;
        scores = new ArrayList<>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public void sortScores() {
        Collections.sort(scores);
    }

    public int getWorstScore() {
        sortScores();
        return scores.get(0);
    }

    public ArrayList<Integer> getScores() {
        ArrayList<Integer> copyOfScores = new ArrayList<>();
        copyOfScores.addAll(scores);
        return copyOfScores;
    }

    public String toString() {
        return name + " plays " + sport;
    }

    public String getName() { return name; }
    public String getSport() { return sport; }
    public void setName(String name) { this.name = name; }
    public void setSport(String sport) { this.sport = sport; }

}
