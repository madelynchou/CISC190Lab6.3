package edu.sdccd.cisc190.character;

import edu.sdccd.cisc190.weapon.Weapon;

public class Fighter extends Character {

    public Fighter(String name, Weapon weapon, int healthPoints, int strengthPoints, int defensePoints) {
        super(name, weapon, healthPoints, strengthPoints, defensePoints);
    }

    public Fighter(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        // deal damaage

        // if opponent still alive, take damage
    }
}
