package DataStructures;

class BasketballPlayer implements Comparable<BasketballPlayer> {

    private String name;
    private int averagePPG;

    public BasketballPlayer(String name, int averagePPG) {
        this.name = name;
        this.averagePPG = averagePPG;
    }

    public String toString() {
        return name + " (" + averagePPG + ")";
    }

    public int compareTo(BasketballPlayer o) {
        return o.averagePPG - this.averagePPG;
    }
}
