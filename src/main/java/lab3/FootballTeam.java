package lab3;

public class FootballTeam implements Comparable {
    private int wins;

    public FootballTeam(int wins) {
        if (wins < 0){
            throw new IllegalArgumentException("Invalid number of wins: " + wins);
        }
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }

    public int compareTo(Object otherTeam) {
        return getWins() - ((FootballTeam) otherTeam).getWins();
    }
}
