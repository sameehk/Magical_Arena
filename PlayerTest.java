// src/test/PlayerTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

public class PlayerTest {

    private Player playerA;
    private Player playerB;

    @BeforeEach
    public void setUp() {
        playerA = new Player("Player A", 100, 10, 5);
        playerB = new Player("Player B", 80, 8, 4);
    }

    @Test
    public void testPlayerInitialization() {
        assertEquals("Player A", playerA.getName());
        assertEquals(100, playerA.getHealth());
        assertTrue(playerA.isAlive());
    }

    @Test
    public void testRollDie() {
        int roll = playerA.rollDie();
        assertTrue(roll >= 1 && roll <= 6, "Die roll should be between 1 and 6.");
    }

    @Test
    public void testTakeDamage() {
        playerA.takeDamage(20);
        assertEquals(80, playerA.getHealth());

        playerA.takeDamage(100); // Damage more than health
        assertEquals(0, playerA.getHealth(), "Health should not go below 0.");
    }

    @Test
    public void testIsAlive() {
        assertTrue(playerA.isAlive());

        playerA.takeDamage(100); // Reduce health to 0
        assertFalse(playerA.isAlive(), "Player should be dead if health is 0.");
    }

    @Test
    public void testAttackPlayer() {
        Player mockPlayerA = Mockito.spy(playerA);
        Player mockPlayerB = Mockito.spy(playerB);

        Mockito.doReturn(6).when(mockPlayerA).rollDie(); // Max attack roll
        Mockito.doReturn(1).when(mockPlayerB).rollDie(); // Min defense roll

        mockPlayerA.attackPlayer(mockPlayerB);

        assertEquals(58, mockPlayerB.getHealth(), "Player B should take 22 damage.");
    }

    @Test
    public void testAttackPlayerZeroDamage() {
        Player mockPlayerA = Mockito.spy(playerA);
        Player mockPlayerB = Mockito.spy(playerB);

        Mockito.doReturn(1).when(mockPlayerA).rollDie(); // Min attack roll
        Mockito.doReturn(6).when(mockPlayerB).rollDie(); // Max defense roll

        mockPlayerA.attackPlayer(mockPlayerB);

        assertEquals(80, mockPlayerB.getHealth(), "Player B should not take any damage.");
    }
}
