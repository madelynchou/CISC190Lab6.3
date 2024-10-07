package edu.sdccd.cisc190.character;

public class Archer extends Character {
    private int numArrows;

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        // deal damage if arrow available

        // take no damage since this is a ranged attack
    }
}
