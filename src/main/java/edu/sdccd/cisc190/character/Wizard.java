package edu.sdccd.cisc190.character;

import edu.sdccd.cisc190.weapon.Staff;
import edu.sdccd.cisc190.weapon.Weapon;

public class Wizard extends Character {
    private int magicPoints;
    private int enchantWeaponPoints;

    public Wizard(String name, Staff staff, int healthPoints, int strengthPoints, int defensePoints, int magicPoints, int enchantWeaponPoints) {
        super(name, staff, healthPoints, strengthPoints, defensePoints);
        this.magicPoints = magicPoints;
        this.enchantWeaponPoints = enchantWeaponPoints;
    }

    public Wizard(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        // deal damage with the enchanted staff if enough magicPoints exist

        // if opponent survives, takes damage
    }

    public void equip(Staff staff) {
        this.we
    }
}
