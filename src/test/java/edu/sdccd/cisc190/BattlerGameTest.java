package edu.sdccd.cisc190;

import edu.sdccd.cisc190.character.Archer;
import edu.sdccd.cisc190.character.Character;
import edu.sdccd.cisc190.character.Fighter;
import edu.sdccd.cisc190.character.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattlerGameTest {
    Character fighterPlayer;
    Character wizardPlayer;
    Character archerPlayer;
    Character fighterBoss;
    Character wizardBoss;
    Character archerBoss;

    @BeforeEach
    void createCharacters() {
        fighterPlayer = BattlerGame.createCharacter("Alice", (byte) 1);
        wizardPlayer = BattlerGame.createCharacter("Bob", (byte) 2);
        archerPlayer = BattlerGame.createCharacter("Charlie", (byte) 3);
        fighterBoss = BattlerGame.createCharacter("Boss", (byte) 1);
        wizardBoss = BattlerGame.createCharacter("Boss", (byte) 2);
        archerBoss = BattlerGame.createCharacter("Boss", (byte) 3);

        assert fighterPlayer != null;
        assertEquals("Alice", fighterPlayer.name);
        assertInstanceOf(Fighter.class, fighterPlayer);
        assert wizardPlayer != null;
        assertEquals("Bob", wizardPlayer.name);
        assertInstanceOf(Wizard.class, wizardPlayer);
        assert archerPlayer != null;
        assertEquals("Charlie", archerPlayer.name);
        assertInstanceOf(Archer.class, archerPlayer);

        assert fighterBoss != null;
        assertEquals("Boss", fighterBoss.name);
        assertInstanceOf(Fighter.class, fighterBoss);
        assert wizardBoss != null;
        assertEquals("Boss", wizardBoss.name);
        assertInstanceOf(Wizard.class, wizardBoss);
        assert archerBoss != null;
        assertEquals("Boss", archerBoss.name);
        assertInstanceOf(Archer.class, archerBoss);
    }

    @Test
    void battleArcherVsArcher() {
        BattlerGame.battle(archerPlayer, archerBoss);
        assertEquals(1, archerPlayer.getHealthPoints());
        assertEquals(-1, archerBoss.getHealthPoints());
    }

    @Test
    void battleArcherVsFighter() {
        BattlerGame.battle(archerPlayer, fighterBoss);
        assertEquals(-1, archerPlayer.getHealthPoints());
        assertEquals(8, fighterBoss.getHealthPoints());
    }

    @Test
    void battleArcherVsWizard() {
        BattlerGame.battle(archerPlayer, wizardBoss);
        assertEquals(2, archerPlayer.getHealthPoints());
        assertEquals(-1, wizardBoss.getHealthPoints());
    }

    @Test
    void battleFighterVsArcher() {
        BattlerGame.battle(fighterPlayer, archerBoss);
        assertEquals(9, fighterPlayer.getHealthPoints());
        assertEquals(-1, archerBoss.getHealthPoints());
    }

    @Test
    void battleFighterVsFighter() {
        BattlerGame.battle(fighterPlayer, fighterBoss);
        assertEquals(2, fighterPlayer.getHealthPoints());
        assertEquals(0, fighterBoss.getHealthPoints());
    }

    @Test
    void battleFighterVsWizard() {
        BattlerGame.battle(fighterPlayer, wizardBoss);
        assertEquals(8, fighterPlayer.getHealthPoints());
        assertEquals(-3, wizardBoss.getHealthPoints());
    }

    @Test
    void battleWizardVsArcher() {
        BattlerGame.battle(wizardPlayer, archerBoss);
        assertEquals(-1, wizardPlayer.getHealthPoints());
        assertEquals(2, archerBoss.getHealthPoints());
    }

    @Test
    void battleWizardVsFighter() {
        BattlerGame.battle(wizardPlayer, fighterBoss);
        assertEquals(-3, wizardPlayer.getHealthPoints());
        assertEquals(8, fighterBoss.getHealthPoints());
    }

    @Test
    void battleWizardVsWizard() {
        BattlerGame.battle(wizardPlayer, wizardBoss);
        assertEquals(0, wizardPlayer.getHealthPoints());
        assertEquals(1, wizardBoss.getHealthPoints());
    }
}