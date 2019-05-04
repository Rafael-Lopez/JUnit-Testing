package lab3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    private static final int ANY_NUMBER = 3;

    public Object[] nbOfGamesWon(){
        return new Integer[]{ 0, 3, 5};
    }

    @Test
    @Parameters(method = "nbOfGamesWon")
    public void constructorShouldSetGamesWon(int wins){
        FootballTeam team = new FootballTeam(wins);

        assertEquals(wins, team.getWins());
    }

    public Object[] illegalNbOfGamesWon(){
        return new Integer[]{ -1, -10};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNbOfGamesWon")
    public void constructorShouldThrowExceptionForInvalidNbOfWins(int wins){
        new FootballTeam(wins);
    }

    @Test
    public void shouldBePossibleToCompareTeams(){
        FootballTeam team = new FootballTeam(ANY_NUMBER);

        assertTrue("FootballTeam should implement Comparabale", team instanceof Comparable);
    }

    @Test
    public void teamsWithMoreMatchesWonShouldBeGreater(){
        FootballTeam teamA = new FootballTeam(2);
        FootballTeam teamB = new FootballTeam(3);

        assertTrue(teamB.compareTo(teamA) > 0);
    }

    @Test
    public void teamsWithLessMatchesWonShouldBeLesser(){
        FootballTeam teamA = new FootballTeam(2);
        FootballTeam teamB = new FootballTeam(3);

        assertTrue(teamA.compareTo(teamB) < 0);
    }

    @Test
    public void teamsWitSameMatchesWonShouldBeEqual(){
        FootballTeam teamA = new FootballTeam(2);
        FootballTeam teamB = new FootballTeam(2);

        assertTrue(teamA.compareTo(teamB) == 0);
    }
}
