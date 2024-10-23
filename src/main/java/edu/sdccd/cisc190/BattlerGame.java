package edu.sdccd.cisc190;

import edu.sdccd.cisc190.character.Archer;
import edu.sdccd.cisc190.character.Character;
import edu.sdccd.cisc190.character.Fighter;
import edu.sdccd.cisc190.character.Wizard;
import edu.sdccd.cisc190.weapon.AshStaff;
import edu.sdccd.cisc190.weapon.LongBow;
import edu.sdccd.cisc190.weapon.Sword;

import java.util.Scanner;

/**
 * BattlerGame is a game battle simulator that supports different
 * types of characters with unique abilities and may equip only
 * specific types of weapons. The project demonstrates Java class
 * inheritance, polymorphism, and dynamic binding.
 *
 * @author Andrew Huang
 */
public class BattlerGame {
    public static void main(String[] args) {
        Character player;
        Character boss;
        String characterName;
        byte characterType;

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Name your character (q to quit): ");
            characterName = input.nextLine();
            if (characterName.equals("q")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }
            System.out.println("Choose your character type: ");
            System.out.println("(1) Fighter");
            System.out.println("(2) Wizard");
            System.out.println("(3) Archer");
            characterType = input.nextByte();

            //TODO handle invalid input exception and validate input before proceeding
            player = createCharacter(characterName, characterType);
            boss = createCharacter("Boss", (byte) (Math.random() * Character.NUM_CHARACTERS + 1));

            if (player == null || boss == null) continue;

            battle(player, boss);

            System.out.printf("%s %s %s!%n", player.getClass().getSimpleName(), player.name, player.isAlive() ? "wins" : "losses");
        }
    }

    /**
     * Player character battles against a boss character to the death
     *
     * @param player the player character attacks first
     * @param boss   the boss defends, then returns attack if still alive
     */
    public static void battle(Character player, Character boss) {
        while (player.isAlive() && boss.isAlive()) {
            player.attack(boss);
            if (boss.isAlive()) boss.attack(player);
        }
    }

    /**
     * Creates and returns a character with base stats and weapon
     *
     * @param characterName the name of the character to create
     * @param characterType what type of character to create, map of id to subclass of Character is contained within this method
     * @return the new character of type, base stats, and name passed in
     */
    public static Character createCharacter(String characterName, byte characterType) {
        return switch (characterType) {
            case 1 -> new Fighter(characterName, 10, 3, 3, new Sword());
            case 2 -> new Wizard(characterName, 5, 1, 1, new AshStaff(), 10, 2, 3);
            case 3 -> new Archer(characterName, 5, 2, 2, new LongBow(), 6);
            default -> null;
        };
    }
}