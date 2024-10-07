package edu.sdccd.cisc190.character;

import edu.sdccd.cisc190.weapon.Weapon;

abstract public class Character {
    public final String name;
    private Weapon weapon;
    private int healthPoints;
    private int strengthPoints;
    private int defensePoints;

    public Character(String name, Weapon weapon, int healthPoints, int strengthPoints, int defensePoints) {
        this.name = name;
        this.weapon = weapon;
        this.healthPoints = healthPoints;
        this.strengthPoints = strengthPoints;
        this.defensePoints = defensePoints;
    }

    public Character(String name) {
        this.name = name;
    }

    abstract public void attack(Character opponent);
}
